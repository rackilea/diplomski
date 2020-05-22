public void close()
   {
      if (isClosed()) return;
      try {
         isClosed = true;
         releaseConnection(); // <= HERE!
      }
      catch (Exception e) {
         throw new ProcessingException(e);
      }
   }