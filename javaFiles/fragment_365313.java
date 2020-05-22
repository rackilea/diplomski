int size = Math.round(64 * getResources().getDisplayMetrics().density);
int imagesLength = 4;
Bitmap bmp = Bitmap.createBitmap(size*imagesLength, size, Bitmap.Config.ARGB_8888); // the bitmap you paint to
Canvas canvas = new Canvas(bmp);
for (int i = 0; i < imagesLength; i++) {
    Bitmap mImage = getImage(i);

    // ...code to get bitmap...
    int width = mImage.getWidth();
    int height= mImage.getHeight();
    float ratio = width/(float)height;
    if(ratio>1)
    {
        mImage = Bitmap.createScaledBitmap(mImage , size, size/ratio, true);
    }
    else
    {
        mImage = Bitmap.createScaledBitmap(mImage , size*ratio, size, true);
    }

    canvas.drawBitmap(mImage,i * size, 0, null);
}