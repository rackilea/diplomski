Canvas currentCanvas = rectangleView.getHolder().lockCanvas();
    if (currentCanvas != null) {

        currentCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        if (detectedFace != null && rectangleFace.height() > 0) {

            int canvasWidth = currentCanvas.getWidth();
            int canvasHeight = currentCanvas.getHeight();
            int faceWidthOffset = rectangleFace.width()/8;
            int faceHeightOffset = rectangleFace.height()/8;

            currentCanvas.save();
            currentCanvas.rotate(360 - orientation_offset, canvasWidth / 2, 
                canvasHeight / 2);

            int l = rectangleFace.right;
            int t = rectangleFace.bottom;
            int r = rectangleFace.left;
            int b = rectangleFace.top;
            int left = (canvasWidth - (canvasWidth*l)/cameraWidth)-(faceWidthOffset);
            int top  = (canvasHeight*t)/cameraHeight - (faceHeightOffset);
            int right = (canvasWidth - (canvasWidth*r)/cameraWidth) + (faceWidthOffset);
            int bottom = (canvasHeight*b)/cameraHeight + (faceHeightOffset);

            currentCanvas.drawRect(left, top, right, bottom, purplePaint);
            currentCanvas.restore();
        }
    }
    rectangleView.getHolder().unlockCanvasAndPost(currentCanvas);