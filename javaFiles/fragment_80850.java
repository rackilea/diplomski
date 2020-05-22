@Override protected void onDraw(Canvas canvas) {
    // Get the current location on screen in pixels (left = 0)
    int[] location = new int[2];
    this.getLocationOnScreen(location);

    // Translate the canvas for the same location as its current offset (resulting in a doubled shift).
    canvas.translate(location[0], 0);

    // Now draw the translated content.
    super.onDraw(canvas);

    this.invalidate();
}