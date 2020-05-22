@Override
public void onPictureTaken(byte[] data, Camera camera) {
  File pictureFile = new File(filename);

  try {
    FileOutputStream fos = new FileOutputStream(pictureFile);
    fos.write(data);
    fos.close();
  } catch (Exception e) {
  }

  Intent intent = this.getIntent();
  intent.putExtra("filename", filename);
  this.setResult(RESULT_OK, intent);
  finish();
}