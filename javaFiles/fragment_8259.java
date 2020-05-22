public static int[][] floodFill(int x, int y, Color targetColor, int[][] image, int[][] filled, int height, int width) {

    //execute something similar once algorithm works. 
    // if (image[x][y] < targetColor.getRGB()/2 || image[x][y] > targetColor.getRGB()*2) return filled;

    if (image[x][y] == Color.blue.getRGB()) {
        System.out.println("returned if 1");
        return filled;
    }
    /*if (image.length < 0 || image[0].length < 0 || image.length >= height || image[0].length >= width) {
        return filled;
    }*/
    filled[x][y] = image[x][y];
    image[x][y] = Color.blue.getRGB();

    if (x - 1 <= 0 && y < width) {
        floodFill(x - 1, y, targetColor, image, filled, height, width);
    }

    if(x + 1 < height && y >= 0 && y < width) {
        floodFill(x + 1, y, targetColor, image, filled, height, width);
    }

    if(x >= 0 && x < height && y - 1 <= 0) {
        floodFill(x, y - 1, targetColor, image, filled, height, width);
    }

    if(x >= 0 && x < height && y + 1 < width) {
        floodFill(x, y + 1, targetColor, image, filled, height, width);
    }

    return filled;
}