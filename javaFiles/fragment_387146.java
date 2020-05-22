//a synthentic anonymous lambda class A implemented Runnable
Runnable r = () -> test.testMethod(); 

//a synthentic anonymous lambda class B implemented Runnable
Runnable r1 = () -> test.testMethod();

r.getClass().equals(r1.getClass());// always return false