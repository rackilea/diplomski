InputStream in = null;
   OutputStream out = null;
   try {
       in = new FileInputStream(inputFileName);
       out = new FileOutputStream(outputFileName);
       copy(in, out);
   finally {
       close(in);
       close(out);
   }

  public static void close(Closeable c) {
     if (c == null) return; 
     try {
         c.close();
     } catch (IOException e) {
         //log the exception
     }
  }