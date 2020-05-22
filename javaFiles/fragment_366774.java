private String saveFile(Bitmap imageToSave, String fileName) {

File file = null;

  try {
    file = new File(new File(Environment.getExternalStorageDirectory() + "/Food"), fileName);
    FileOutputStream out = new FileOutputStream(file);
    imageToSave.compress(Bitmap.CompressFormat.JPEG, 100, out);
    out.flush();
    out.close();

  } catch (Exception e) {
    e.printStackTrace();
  }

  return file.getAbsolutePath();
}