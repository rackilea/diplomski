if (xPos > xMax) {
    xPos = xMax;
    xVel *= -1.0;
} else if (xPos < 0.0) {
    xPos = 0.0;
    xVel *= -1.0;
}