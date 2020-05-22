for(File f : files){
   try {
       process(f); // may throw various exceptions
   } catch (Exception e) {
       logger.error(e.getMessage(), e);
   }
}