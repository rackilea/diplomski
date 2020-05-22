int numColors = 10;
int colors[] = new int[numColors];
Random random = new Random(0);
for (int i=0; i<numColors; i++) {
    colors[i] = 0xFF000000 | random.nextInt();
}

// In your loop:
img.setRGB(i,j, colors[newPixel[i][i]]);