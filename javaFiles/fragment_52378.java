File sourceFile = new File("D:\\testencrypted.zip");    
InputStream input= new FileInputStream(sourceFile);

// Upload the file...
// Make sure you close the input stream first ;)

if (!sourceFile.delete()) {

  System.out.println("Failed to delete " + sourceFile + " from local disk");
  sourceFile.deleteOnExit(); // try and delete on JVM exit...

}