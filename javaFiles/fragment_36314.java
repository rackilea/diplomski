int inputPixel = inputData.getPixel(x,y);

RGB rgb = inputData.palette.getRGB(inputPixel);

int outputPixel = manipulatedImageData.palette.getPixel(rgb);

manipulatedImageData.setPixel(x, y, outputPixel);