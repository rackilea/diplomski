SynchronizedTest test = new SynchronizedTest();
Thread thread01 = new Thread(test);
thread01.start();
System.out.println(test.b);
System.out.println(test.b);
test.test02();
System.out.println(test.b);