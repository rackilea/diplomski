You can query the JVM to see how much free and used memory there is :

/* Total amount of free memory available to the JVM */
System.out.println("Free memory (bytes): " + 
Runtime.getRuntime().freeMemory());

/* This will return Long.MAX_VALUE if there is no preset limit */
long maxMemory = Runtime.getRuntime().maxMemory();
 /* Maximum amount of memory the JVM will attempt to use */
System.out.println("Maximum memory (bytes): " + 
(maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

/* Total memory currently in use by the JVM */
System.out.println("Total memory (bytes): " + 
Runtime.getRuntime().totalMemory());