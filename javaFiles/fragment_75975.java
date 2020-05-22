long getAvailableMemory() {
  Runtime runtime = Runtime.getRuntime();
  long totalMemory = runtime.totalMemory(); // current heap allocated to the VM process
  long freeMemory = runtime.freeMemory(); // out of the current heap, how much is free
  long maxMemory = runtime.maxMemory(); // Max heap VM can use e.g. Xmx setting
  long usedMemory = totalMemory - freeMemory; // how much of the current heap the VM is using
  long availableMemory = maxMemory - usedMemory; // available memory i.e. Maximum heap size minus the current amount used
  return availableMemory;
}