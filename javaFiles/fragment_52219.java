public void changeBackground(Bitmap bitmap){
        //store image to local var
        image = bitmap;
        //get offset of resolution between image and canvas
        offSetY = (float)image.getHeight()/getHeight();
        offSetX = (float)image.getWidth()/getWidth();
        //creating new canvas
        // DON'T COPY IMAGE canvasBitmap = image.copy(Bitmap.Config.ARGB_8888, true);
        // just make a blank bitmap
        canvasBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //when size changed, store the new size
        destImageRect = new Rect(0,0,w,h);

        // DON'T COPY IMAGE - just make a blank bitmap
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.scale(mScaleFactor, mScaleFactor, pivotPointX, pivotPointY);
        clipBounds = canvas.getClipBounds();
        if (image != null) {
            canvas.drawBitmap(image, 0, 0, canvasPaint);
        }
        // first update the canvas bitmap
        drawCanvas.drawPath(drawPath, drawPaint);
        // then draw it on top of the image
        canvas.drawBitmap(canvasBitmap,null, destImageRect,canvasPaint);
        canvas.restore();
    }