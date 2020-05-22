if (semaphore.tryAquire(5, TimeUnit.SECONDS)) {
   ...
   // Permit was granted before timeout
} else {
   // We timed out while waiting
}