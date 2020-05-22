public static boolean isGrayscale(Image image) {
    ImageData data = image.getImageData(); // or new ImageData("C:\\image.bmp"); 
    RGB[] rgbs = data.getRGBs();
    for (int i = 0; i < rgbs.length; i++) {
       if (!isShadowOfGray(rgbs[i])) {
          return false;
       }
    }
    return true;
}

public static boolean isShadowOfGray(RGB color) {
   return color.red == color.green && color.green == color.blue;
}