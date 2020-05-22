FileInputStream is = new FileInputStream(f1);
try {
  FileOutputStream os = new FileOutputStream(f2);
  try {
    copyFromInToOut(is, os);
    os.flush();
  } finally {
    os.close();
  }
} finally {
  is.close();
}