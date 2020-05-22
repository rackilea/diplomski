File peopledetail_file = new File(this.getFilesDir(), "PeopleDetailsFile");
peopledetail_file.createNewFile();
FileOutputStream fos = new FileOutputStream(peopledetail_file);
// do writing ...
PrintWriter pw = new PrintWriter(fos);
pw.print("Hello");
pw.flush
fos.flush();
fos.close();