private final Matrix mMyMatrix = new Matrix();

// Assumes that the grid covers the whole View.
private final float[] mOriginalGridCorners = new float[] {
    0, 0,                   // top left (x, y)
    getWidth(), getHeight() // bottom right (x, y)
};

private final float[] mTransformedGridCorners = new float[4];

@Override
public boolean onTouchEvent(MotionEvent event) {
    if (/* User pans the screen */) {
        mMyMatrix.postTranslate(deltaX, deltaY);
    }

    if (/* User zooms the screen */) {
        mMyMatrix.postScale(deltaScale, deltaScale);
    }

    if (/* User taps the grid */) {
        // Transform the original grid corners to where they
        // are on the screen (panned and zoomed).
        mMyMatrix.mapPoints(mTransformedGridCorners, mOriginalGridCorners);
        float gridWidth = mTransformedGridCorners[2] - mTransformedGridCorners[0];
        float gridHeight = mTransformedGridCorners[3] - mTransformedGridCorners[1];
        // Get the x and y coordinate of the tap inside the
        // grid, between 0 and 1.
        float x = (event.getX() - mTransformedGridCorners[0]) / gridWidth;
        float y = (event.getY() - mTransformedGridCorners[1]) / gridHeight;
        // To get the tapped grid cell.
        int column = (int)(x * nbrColumns);
        int row = (int)(y * nbrRows);
        // Or to get the tapped exact pixel in the original grid.
        int pixelX = (int)(x * getWidth());
        int pixelY = (int)(y * getHeight());
    }
    return true;
}

@Override
protected void onDraw(Canvas canvas) {
    // Each frame, transform your canvas with the matrix.
    canvas.save();
    canvas.concat(mMyMatrix);
    // Draw grid.
    grid.draw(canvas);
    canvas.restore();
}