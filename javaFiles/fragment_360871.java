short[] red = new short[256];
short[] green = new short[256];
short[] blue = new short[256];
short[] alpha = new short[256];

for (short i = 0; i < 256; i++) {
  green[i] = blue[i] = 0;
  alpha[i] = red[i] = i;
}
short[][] data = new short[][] {
    red, green, blue, alpha
};

LookupTable lookupTable = new ShortLookupTable(0, data);
LookupOp op = new LookupOp(lookupTable, null);
BufferedImage destinationImage = new BufferedImage(24, 24, BufferedImage.TYPE_INT_ARGB);
destinationImage = op.filter(sourceImage, destinationImage);