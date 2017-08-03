package junit.spring.test;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {

	protected static Logger logger = LoggerFactory.getLogger(BaseTest.class);

	// ClassPathXmlApplicationContext acProvider ;
	//
	// ClassPathXmlApplicationContext acCustomer;
	//
	protected ClassPathXmlApplicationContext ac;

	@Before
	public void testBefore() {
		Log log = Log.getLogger();
		logger.debug("-------------------------------------");
		logger.debug("public void testBefore()");
		// acProvider = new ClassPathXmlApplicationContext("dubbo/dubbo-provider.xml");
		ac = new ClassPathXmlApplicationContext("beans.xml");
		ac.start();

		// acCustomer = new ClassPathXmlApplicationContext("dubbo/dubbo-customer.xml");
		// // acProvider.start();
		// acCustomer.start();

	}

	@After
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
