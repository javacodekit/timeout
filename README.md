2017.8.3
清晰的打印出了超时方法，以及子方法的耗时时间
void junit.spring.test.TestImpl.test(String), cost=8516ms, args=[123]
	-void junit.spring.test.TestImpl.test1(), cost=100ms, args=[]
	-void junit.spring.test.TestImpl.test2(), cost=3360ms, args=[]
		-void junit.spring.test.TestImpl.test3(int), cost=3330ms, args=[2000]
	-void junit.spring.test.TestImpl.test4(), cost=5001ms, args=[]
		-void junit.spring.test.TestImpl.test5(String), cost=2001ms, args=[2000]
			-void junit.spring.test.TestImpl.test6(String), cost=1001ms, args=[6000]
		-void junit.spring.test.TestImpl.test7(String), cost=1000ms, args=[2000]
		-void junit.spring.test.TestImpl.test8(String), cost=1000ms, args=[2000] 