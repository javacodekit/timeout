package junit.spring.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TimeoutNGTest {

	protected static Logger logger = LoggerFactory.getLogger(TimeoutNGTest.class);

	// ClassPathXmlApplicationContext acProvider ;
	//
	// ClassPathXmlApplicationContext acCustomer;
	//
	ClassPathXmlApplicationContext ac;

	@Test(invocationCount = 10000, threadPoolSize = 100)
	public void testTimeout() {
		ITest d = (ITest) ac.getBean("testImpl");
		d.test("123");
	}

	@BeforeSuite
	public void testBefore() {
		logger.debug("-------------------------------------");
		logger.debug("public void testBefore()");
		// acProvider = new ClassPathXmlApplicationContext("dubbo/dubbo-provider.xml");
		ac = new ClassPathXmlApplicationContext("applicationContext-live.xml");
		ac.start();

		// acCustomer = new ClassPathXmlApplicationContext("dubbo/dubbo-customer.xml");
		// // acProvider.start();
		// acCustomer.start();

	}

	@AfterSuite
	public void testEnd() {
		logger.debug("-------------------------------------");
		logger.debug("public void testEnd()");

		if (null != ac) {
			ac.close();
			ac = null;
		}

		// if (null != acProvider) {
		// acProvider.close();
		// acProvider = null;
		// }
	}
}
