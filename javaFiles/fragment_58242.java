redValue = pixelColor.getRed();                         
greenValue = pixelColor.getGreen();                     
blueValue = pixelColor.getBlue();
greyValue = (int)((redValue + greenValue + blueValue)/3)                  
pixelColor = new Color(greyValue, greeyValue, greyValue);
targetPixel.setColor(pixelColor);