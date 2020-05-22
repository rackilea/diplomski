DisplayBitmapsScreen()
{    
 //Bitmap bitmap = EncodedImage.getEncodedImageResource("images/image.png").getBitmap();
 try {
  FileConnection fc = (FileConnection) Connector.open("file:///SDCard/BlackBerry/pictures/image.png");
  if (fc.exists()) {
   byte[] image = new byte[(int) fc.fileSize()];
   InputStream inStream = fc.openInputStream();
   inStream.read(image);
   inStream.close();
   EncodedImage encodedImage = EncodedImage.createEncodedImage(image, 0, -1);
   BitmapField bitmapField = new BitmapField(encodedImage.getBitmap());
   fc.close();
   add(bitmapField);
  }
 } catch (Exception e) { System.out.println("EXCEPTION " + e); }
}