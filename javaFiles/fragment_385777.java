public static Point findColor(Box searchArea, int r, int g, int b, int tolerance){
    System.out.println("Test");

    // Pre-calc RGB "tolerance" values out of the loop (min is 0 and max is 255)
    int minR = Math.max(r - tolerance, 0);
    int minG = Math.max(g - tolerance, 0);
    int minB = Math.max(b - tolerance, 0);
    int maxR = Math.min(r + tolerance, 255);
    int maxG = Math.min(g + tolerance, 255);
    int maxB = Math.min(b + tolerance, 255);

    BufferedImage image = generateScreenCap(searchArea);
    for (int i = 0; i < image.getWidth(); i++) {
        for (int j = 0; j < image.getHeight(); j++) {
            // get single RGB pixel
            int color = image.getRGB(i, j);

            // get individual RGB values of that pixel
            // (could use Java's Color class but this is probably a little faster)
            int red = (color >> 16) & 0x000000FF;
            int green = (color >>8 ) & 0x000000FF;
            int blue = (color) & 0x000000FF;  

            if ( (red >= minR && red <= maxR) &&
                 (green >= minG && green <= maxG) &&
                 (blue >= minB && blue <= maxB) ) 
                return new Point(i + searchArea.x1, j + searchArea.y1);
        }
    }
    return new Point(-1, -1);
}