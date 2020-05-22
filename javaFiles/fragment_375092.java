public void run() {
    try {
      InputStream in = socket.getInputStream();


  int nof_files = ByteStream.toInt(in);

  for (int cur_file=0;cur_file < nof_files; cur_file++) {
    String file_name = ByteStream.toString(in);

    File file=new File(folder, file_name);

    ByteStream.toFile(in, file);
  }
}
catch (java.lang.Exception ex) {
  ex.printStackTrace(System.out);
}