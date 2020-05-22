void onEvent(T event, long sequence, boolean endOfBatch) throws Exception {
    // instanceNumber could be assigned in a constructor 
   if ((sequence % 4) != instanceNumber) 
        // message isn't for me
        return;
   }
   // do my thing
}