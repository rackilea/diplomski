public void onDraw(Canvas canvas) {


     // we draw our auxiliary bitmap that contains all the trails
     canvas.drawBitmap (mTransparentBitmapForTrails, 0, 0, mTransparentBitmapPaint);
     .
     // then we draw the usual stuff, characters, etc...
     canvas.drawBitmap (mCharacterBimap, mPosX, mPosY, mCharacterPaint);
     .
     .
} 

// this creates a transparent background the size of the screen
// you will render trails here and they all will be painted at once in onDraw below the craracters

Bitmap mBitmapForTrails;
Canvas mCanvasForTrails;

public void initializeBitmapForTrails() {
      mBitmapForTrails=new Bitmap(); // checkout how to create bitmaps with specific w&h, can't remember at the moment. 
      mCanvasForTrails=new Canvas(mBitmapForTrails); // we create a canvas to draw in that bitmap
}

// this will paint the trail in our secondary bitmap. This secondary bitmap doesn't get
// erased, so the drawTrail()'s are accumulative

public void drawTrail (int x, int y) {
   mCanvasForTrails.drawBitmap(your_cool_trail_bitmap, x, y, mTrailPaint);
   invalidate(); // this works, but for performance you'll later do invalidate(rect), so Android only repaints the changed portion of the bitmap. That rect will be the rectangle occupied by the trail bitmap. ie. (x,y,x+trailw,y+trialh)
}