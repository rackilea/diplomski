@Override protected void onDestroy() {
  super.onDestroy();
  if(!isChangingConfigurations()) {
    deleteTempFiles(getCacheDir());
  }
}

private boolean deleteTempFiles(File file) {
  if (file.isDirectory()) {
    File[] files = file.listFiles();
    if (files != null) {
      for (File f : files) {
        if (f.isDirectory()) {
          deleteTempFiles(f);
        } else {
          f.delete();
        }
      }
    }
  }
  return file.delete();
}