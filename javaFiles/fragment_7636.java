public void copyURLToFile(u, f) {
    InputStream in = u.openStream();        
    try {
       FileOutputStream out = new FileOutputStream(f);
       try {                  
          byte[] buffer = new byte[1024];
          int count;
          while ((count = in.read(buffer) > 0) {
             out.write(buffer, 0, count);
          }
          out.flush();
       } finally {
          out.close();
       }
    } finally {
       in.close();
    }
}