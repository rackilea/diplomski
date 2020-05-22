class PixelCoordinate {
    public int x;
    public int y;
    public PixelCoordinate(int x, int y) {
        this.x = x; this.y = y;
    }
}

Color beforeColor = img[x][y];
List<PixelCoordinate> worklist = new ArrayList<PixelCoordinate>();
// The pixel to start with
worklist.add(new PixelCoordinate(x, y));
while (worklist.isEmpty() == false) {
    // Take one pixel from the list
    PixelCoordinate pixel = list.get(0);
    list.remove(0);

    // Check its color
    if (img[x][y].equals(beforeColor) {
        // Apply new color
        img[x][y] = foregroundColor;
        // Check neighbors
        if (x-1 >= 0) {
            list.add(new PixelCoordinate(x-y, y));
        }
        // Add other neighbors...
    }
}