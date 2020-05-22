int avgRed = 0;
int avgGreen = 0;
int avgBlue = 0;
for (int i = 0; i < length; i ++) {
    avgRed += array[i].getRed();
    avgBlue += array[i].getBlue();
    avgGreen += array[i].getGreen();
}
Color avgColor = new Color(avgRed / length, avgBlue / length, avgGreen / length);