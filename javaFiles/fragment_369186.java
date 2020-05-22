String strFilePath = "d:/FileIO.txt";

 try
 {
  FileOutputStream fos = new FileOutputStream(strFilePath);
  String strContent = "Write File using Java FileOutputStream example !";

  /*
   * To write byte array to a file, use
   * void write(byte[] bArray) method of Java FileOutputStream class.
   *
   * This method writes given byte array to a file.
   */

   fos.write(strContent.getBytes());

  /*
   * Close FileOutputStream using,
   * void close() method of Java FileOutputStream class.
   *
   */

   fos.close();

 }
 catch(FileNotFoundException ex)
 {
  System.out.println("FileNotFoundException : " + ex);
 }
 catch(IOException ioe)
 {
  System.out.println("IOException : " + ioe);
 }