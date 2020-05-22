private byte[] scaleImage(Bitmap image) {
  byte[] image = new byte[]{};
  int width = image.getWidth();
  int height = image.getHeight();
  int newHeight, newWidth;
  if (width > 250 || height > 250) {
    if (width > height) { //landscape-mode
      newHeight = 250;
      newWidth = (newHeight * width) / height;
    } else {
      newWidth = 250;
      newHeight = (newWidth * height) / width;
    }
  } else {
    // Whatever you want to do here
  }
  // Now use newWidth and newHeight
}