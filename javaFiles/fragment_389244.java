// We declare our array to handle 20 elements since
// the image will be dissected into 20 quadrants.
Color[] quadrantColors = new Color[20];

BufferedImage img = null;

// Fill our Color Array...
getQuadrantsColorAverages(quadrantColors, img);

// Let's see what we managed to get....
for (int i = 0; i < quadrantColors.length; i++) {
    Color clr =  quadrantColors[i];
    int red = clr.getRed();
    int green = clr.getGreen();
    int blue = clr.getBlue();

    System.out.println("The average color for Quadrant #" + 
       (i + 1) + " is: RGB[" + red + "," + green + "," + blue + "]");
}