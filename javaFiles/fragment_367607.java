// Reproject raster
Object pixel = null;

Raster from = img.getRaster();
WritableRaster to = img2.getRaster(); // Assuming img2.getType() == img.getType() always

for (int y = 0; y < img.getHeight(); y++) {
    for (int x = 0; x < img.getWidth(); x++) {
        // Color of the pixel
        pixel = from.getDataElements(x, y, pixel);

        // Its new coordinates
        int X = (int) (x * Math.cos(y * Math.pi/180));
        int Y = y;

        // Set X,Y,pixel to the new raster
        to.setDataElements(X, Y, pixel);                 
   }