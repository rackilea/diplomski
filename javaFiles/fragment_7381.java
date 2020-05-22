File myFile = new File(Environment.getExternalStorageDirectory() + File.separator + "/mydir" + "file.txt");
  if (!myFile.exists()) {
        txtTitletosave = "file";
  } else {
       int count = new File(Environment.getExternalStorageDirectory() + File.separator + "/mydir").list().length;
       txtTitletosave = "file"+count;
  }