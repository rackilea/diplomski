protected void onDraw(Canvas canvas) {
    if (forceClear) {
        canvas.drawColor(Color.BLACK);  // or whatever color works best for you.
        forceClear = false;
    } else {
        canvas.drawPath(path, paint);
    }
}