System.gc();
System.runFinalization();
Thread.sleep(1000);
long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

//build object here

System.gc();
System.runFinalization();
Thread.sleep(1000);
long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

long objectSize = after - before;