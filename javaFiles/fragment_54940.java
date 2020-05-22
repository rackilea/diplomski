/* Returns the maximum amount of memory available to 
   the Java Virtual Machine set by the '-mx' or '-Xmx' flags. */
Runtime.getRuntime().maxMemory();

/* Returns the total memory allocated from the system 
   (which can at most reach the maximum memory value 
   returned by the previous function). */
Runtime.getRuntime().totalMemory();

/* Returns the free memory *within* the total memory 
   returned by the previous function. */
Runtime.getRuntime().freeMemory();