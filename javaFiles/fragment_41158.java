BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

WritableRaster raster = image.getRaster();
for ( i=0; i<width; i++ ) {
    for (  j=0; j<height; j++ ) {
        int[] colorArray = getColorForPixel(pixels[i][j]);
        raster.setPixel(i, j, colorArray);
    }
}

ImageIO.write(image, "gif", new File("CardImage"));