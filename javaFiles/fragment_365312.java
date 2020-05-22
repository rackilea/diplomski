int size = Math.round(64 * getResources().getDisplayMetrics().density);
int imagesLength = 4;
Bitmap bmp = Bitmap.createBitmap(size*imagesLength, size, Bitmap.Config.ARGB_8888); // the bitmap you paint to
Canvas canvas = new Canvas(bmp);
for (int i = 0; i < imagesLength; i++) {
    Bitmap mImage = getImage(i);

    // ...code to get bitmap...
    mImage = Bitmap.createScaledBitmap(mImage , size, size, true);

    canvas.drawBitmap(mImage,i * size, 0, null);
}