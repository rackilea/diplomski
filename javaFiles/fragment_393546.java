FirebaseVisionImage image;

try {
  image = FirebaseVisionImage.fromFilePath(
             MainMenuActivity.this,
             Uri.fromFile(new File("/sdcard/Download/test.jpg"))
          );
} catch (IOException e) {
  e.printStackTrace();
}