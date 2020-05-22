private void drawSecondLayerTake4(GC gc, int x, int y) {

    final int width = 300;
    final int height = 300;

    final Image src = new Image(null, width, height);

    final GC imageGC = new GC(src);

    imageGC.setAntialias(SWT.ON);

    // This sets the alpha on the entire canvas to transparent
    imageGC.setAlpha(0);
    imageGC.fillRectangle(0, 0, width, height);

    // Reset our alpha and draw the ovals
    imageGC.setAlpha(255);
    imageGC.setBackground(red);
    imageGC.fillOval(70, 70, 60, 60);
    imageGC.fillOval(100, 100, 60, 60);

    // We're done with the GC, so dispose of it
    imageGC.dispose();

    final ImageData imageData = src.getImageData();
    imageData.alphaData = new byte[width * height];

    // This is the hacky bit that is making assumptions about
    // the underlying ImageData.  In my case it is 32 bit data
    // so every 4th byte in the data array is the alpha for that
    // pixel...
    for (int idx = 0; idx < (width * height); idx++) {
        final int coord = (idx * 4) + 3;
        imageData.alphaData[idx] = imageData.data[coord];
    }

    // Now that we've set the alphaData, we can create our
    // final image
    final Image processedImage = new Image(Display.getCurrent(), imageData);

    gc.setAlpha(100);
    gc.drawImage(processedImage, x + 0, y + 0);

    // And get rid of the canvas
    src.dispose();

}