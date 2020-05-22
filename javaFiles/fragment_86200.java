void drawCircles(Graphics graphics, int xMid, int yMid, int radius) {
    // end recursion
    if(radius < 5)
        return;

    // Draw circle
    graphics.drawOval(xMid - radius, yMid - radius, radius * 2, radius * 2);

    // start recursion
    //left
    drawCircles(graphics, xMid-radius, yMid, radius / 2);
    //right
    drawCircles(graphics, xMid+radius, yMid, radius / 2);
}