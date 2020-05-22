long myTotalMemoryBefore = Runtime.getRuntime().totalMemory();

/* Fill the hash Table */

long myTotalMemoryAfter = Runtime.getRuntime().totalMemory();
long myHashMapMemory = myTotalMemoryAfter - myTotalMemoryBefore;