public int[] setOval(int currentX, int currentY) {
    drawOval = true;
    int[] toReturn = {ovalX, ovalY};
    ovalX = currentX;
    ovalY = currentY;
    return toReturn;
}

public void removeOval() {
    drawOval = false;
}