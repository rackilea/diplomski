String s = "hello world";

ByteArrayOutputStream baos = new ByteArrayOutputStream();
try(ZipOutputStream zos = new ZipOutputStream(baos)) {

  /* File is not on the disk, test.txt indicates
     only the file name to be put into the zip */
  ZipEntry entry = new ZipEntry("test.txt"); 

  zos.putNextEntry(entry);
  zos.write(s.getBytes());
  zos.closeEntry();

  /* use more Entries to add more files
     and use closeEntry() to close each file entry */

  } catch(IOException ioe) {
    ioe.printStackTrace();
  }