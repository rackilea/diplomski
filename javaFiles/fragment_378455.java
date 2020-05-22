FileOutputStream fos = new FileOutputStream(strFilePath);
  String strContent = "Content";

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