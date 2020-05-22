try {
        // String mFilePath  : Absolute Path of the file to be saved 

        // Bitmap mBitmap1   : First bitmap. This goes as background.
        // Bitmap mCBitmap   : Bitmap associated with the Canvas. All draws on the canvas are drawn into this bitmap.
        // Bitmap mBitmap2   : Second bitmap. This goes on top of first (in this example serves as foreground.

        // Paint mPaint1     : Paint to draw first bitmap
        // Paint mPaint2     : Paint to draw second bitmap on top of first bitmap

        Bitmap mCBitmap = Bitmap.createBitmap(mBitmap1.getWidth(), mBitmap1.getHeight(), mBitmap1.getConfig());

        Canvas tCanvas = new Canvas(mCBitmap);

        tCanvas.drawBitmap(mBitmap1, 0, 0, mPaint1);

        mPaint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
        // XFer modes define the overlay characteristic

        tCanvas.drawBitmap(mBitmap2, 0, 0, mPaint2);

        FileOutputStream stream = new FileOutputStream(mFilePath);
        mCBitmap.compress(CompressFormat.JPEG, 100, stream);

        stream.flush();
        stream.close();
    } catch(Exception e) {
        Log.e("Could not save", e.toString());
}