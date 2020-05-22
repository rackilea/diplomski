Runtime runtime = Runtime.getRuntime();
long maxMemory = runtime.maxMemory();
long mTotalMemory = runtime.totalMemory();
long freeMemory = runtime.freeMemory();
int mAvailableProcessors = runtime.availableProcessors();

long mTotalFreeMemory = freeMemory + (maxMemory - mTotalMemory);