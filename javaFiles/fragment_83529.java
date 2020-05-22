try {
  // exception throwing code
} catch(Exception e) {
   // either
   log.error("Error fooing bar",e);
   // OR
   throw new RuntimeException(e);
}