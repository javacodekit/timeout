package com.liuyh.timeout;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 超时打印注解.
 * 
 * @author liuyonghong
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeoutRecordable {

	public String name() default "";

	public long value() default 1000;

	public int level() default 0;

}
