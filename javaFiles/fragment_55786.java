public void encodeMessage(Picture stegoObject, int[] binaryArray) {
    Pixel pixelTarget = new Pixel(stegoObject, 0, 0);
    Pixel[] pixelArray = stegoObject.getPixels();
    Color pixelColor = null;
    int redValue = 0;

    for (int x = 0; x < binaryArray.length; x++) {
        redValue = binaryArray[x];
        pixelTarget = pixelArray[x];
        pixelTarget.setRed(redValue);
    }
    pixelTarget = pixelArray[binaryArray.length];
    pixelTarget.setRed(255);