//rename file
File file = new File("oldname");
File file2 = new File("newname");
boolean success = file.renameTo(file2);

//delete file
File f = new File("fileToDelete");
boolean success = f.delete();