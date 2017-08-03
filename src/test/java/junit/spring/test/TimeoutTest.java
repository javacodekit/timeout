package junit.spring.test;

import org.junit.Test;

/**
 * 
 *
 * @author liuyonghong
 */
public class TimeoutTest extends BaseTest {

	ITest d;

	@Test
	public void test() {
		d = (ITest) ac.getBean("testImpl");
		d.test("123");
	}
}
