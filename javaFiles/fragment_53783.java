@Override
protected void onDraw(Canvas canvas) {
    canvas.save();
    // Transform canvas and draw the grid.
    grid.draw(canvas);
    // Get the matrix from canvas. Can be used to transform
    // corners on the next touch event.
    canvas.getMatrix(mMyMatrix);
    canvas.restore();
}