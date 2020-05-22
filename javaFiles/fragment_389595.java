int dstWidth = width of the flag rectangle;
int dstHeight = height of the flag rectangle;
int pixelArray[] = new int[dstWidth * dstHeight];

int startX = start X position of your flag;
int endX = end X position of your flag;
int startY = start Y position of your flag;
int endX = end Y position of your flag;

bitmap.getPixels(pixelArray, 0, startX, startX, startY, dstWidth, dstHeight);