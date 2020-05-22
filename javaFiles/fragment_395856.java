@Override
    public void onDraw(Canvas canvas, Rect bounds) {
        if (mCurrentWatchFaceDrawer != null) {
          mCurrentWatchFaceDrawer.draw(canvas, bounds);
        }
    }