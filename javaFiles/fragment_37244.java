ZipOutputStream outStream = new ZipOutputStream(new FileOutputStream(zipFileName));

 // Add a zip entry to the output stream
 outStream.putNextEntry(new ZipEntry(myEntryName));

 // add data to your entry by writing to outStream
 ......
 ......
 //Close zip entry and file streams
 outStream.closeEntry();