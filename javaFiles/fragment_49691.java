Image scaled = new Image(Display.getDefault(), width, height);
GC gc = new GC(scaled);
gc.setAntialias(SWT.ON);
gc.setInterpolation(SWT.HIGH);
gc.drawImage(image, 0, 0,image.getBounds().width, image.getBounds().height, 0, 0, width, height);
gc.dispose();

// Image data from scaled image and transparent pixel from original

ImageData imageData = scaled.getImageData();

imageData.transparentPixel = image.getImageData().transparentPixel;

// Final scaled transparent image

Image finalImage = new Image(Display.getDefault(), imageData);

scaled.dispose();