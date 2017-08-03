package com.liuyh.timeout;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 打印超时的service方法.
 * 
 * @author liuyonghong
 */
public class TimeoutRecordableInterceptor {
	Logger logger = Logger.getLogger(TimeoutRecordableInterceptor.class);
	private static ThreadLocal<TreeMap> tl = new ThreadLocal<TreeMap>();

	public Object doAround(ProceedingJoinPoint point, TimeoutRecordable recordable) throws Throwable {
		Object[] args = point.getArgs();
		String arg = Arrays.toString(args);
		long startMillis = System.currentTimeMillis();
		String name = recordable.name();
		if (StringUtils.isBlank(name)) {
			name = String.valueOf(point.getSignature());
		}
		long timeout = recordable.value();

		try {
			return point.proceed();
		} finally {
			long cost = System.currentTimeMillis() - startMillis;
			TreeMap map = tl.get();
			if (map == null) {
				map = new TreeMap();
			}
			TimeoutMethod tm = new TimeoutMethod(name, cost, arg, recordable.level());
			map.put(name, tm);
			tl.set(map);
			// System.out.println(name + "---------------" + cost);
			if (timeout > 0 && cost > recordable.value() && recordable.level() == 0) {
				String rn = System.getProperty("line.separator");
				Set s = map.keySet();
				Iterator it = s.iterator();
				StringBuffer sb = new StringBuffer();
				while (it.hasNext()) {
					String key = (String) it.next();
					TimeoutMethod val = (TimeoutMethod) map.get(key);
					sb.append(rn + val.toString());
				}
				// logger.warn(String.format("%s cost: %sms,arg:%s %s", name, cost, arg, sb.toString()));
				logger.warn(String.format("%s ", sb.toString()));
			}
			if (recordable.level() == 0 && tl != null) {
				tl.get().clear();
				tl.remove();
			}
		}

	}
}
