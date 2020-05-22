int width = 200;
int height = 200;
int xMid = width/2;
int yMid = width/2;
while(width > 0 && height > 0) {
    // Draw the square
    int xLeft = xMid - width/2;
    int xRight = xMid + width/2;
    int yTop = yMid - height/2;
    int yBottom = yMid + height/2;
    int[] xPoints = {xLeft, xRight, xRight, xLeft};
    int[] yPoints = {yTop, yTop, yBottom, yBottom};
    int nPoints = 4;
    g.drawPolygon(xPoints, yPoints, nPoints);

    // Change the dimensions
    width -= 20;
    height -= 20;
}