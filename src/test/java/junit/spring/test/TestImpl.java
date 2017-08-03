package junit.spring.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.liuyh.timeout.BeanSelfAware;
import com.liuyh.timeout.TimeoutRecordable;

@Component("testImpl")
public class TestImpl implements ITest, BeanSelfAware {
	protected static Logger logger = LoggerFactory.getLogger(TestImpl.class);

	@Override
	@TimeoutRecordable(value = 3000)
	public void test(String s) {
		try {
			System.out.println("test父方法被调用,延迟3000毫秒");
			Thread.sleep(50);
			this.proxySelf.test1();
			this.proxySelf.test2();
			this.proxySelf.test4();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@TimeoutRecordable(level = 1)
	public void test1() {
		try {
			System.out.println("test1子方法,父亲是test被调用,延迟100毫秒");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@TimeoutRecordable(level = 1)
	public void test2() {
		try {
			System.out.println("test2子方法,父亲是test被调用,延迟3360毫秒");
			Thread.sleep(30);
			this.proxySelf.test3(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@TimeoutRecordable(level = 1)
	public void test4() {
		try {
			System.out.println("test4子方法,父亲是test被调用,延迟2000毫秒");
			Thread.sleep(1000);
			this.proxySelf.test5("2000");
			this.proxySelf.test7("2000");
			this.proxySelf.test8("2000");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@TimeoutRecordable(level = 2)
	public void test5(String i) {
		try {
			System.out.println("test5子方法,父亲是test4被调用,延迟1000毫秒,i=" + i);
			Thread.sleep(1000);
			this.proxySelf.test6("6000");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@TimeoutRecordable(level = 3)
	public void test6(String i) {
		try {
			System.out.println("test6子方法,父亲是test5被调用,延迟1000毫秒,i=" + i);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@TimeoutRecordable(level = 2)
	public void test7(String i) {
		try {
			System.out.println("test7子方法,父亲是test4被调用,延迟1000毫秒,i=" + i);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@TimeoutRecordable(level = 2)
	public void test8(String i) {
		try {
			System.out.println("test8子方法,父亲是test4被调用,延迟1000毫秒,i=" + i);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@TimeoutRecordable(level = 2)
	public void test3(int i) {
		try {
			System.out.println("test3子方法,父亲是test2被调用,延迟3330毫秒");
			Thread.sleep(3330);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setSelf(Object proxyBean) {
		// TODO Auto-generated method stub
		this.proxySelf = (ITest) proxyBean;
	}

	ITest proxySelf;

}
