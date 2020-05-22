private void drawCircle(Canvas canvas, PointF center, boolean animationFlag) {
        int iconSize = (int) LayoutUtil.getPixelFromDp(MARKER_SIZE, getContext());
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.android);
        Bitmap scaled = Bitmap.createScaledBitmap(bitmap, iconSize, iconSize, true);
        canvas.drawBitmap(scaled, center.x - (iconSize >> 1), center.y - (iconSize >> 1), signPaint);
    }