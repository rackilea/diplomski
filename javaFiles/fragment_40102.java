class drawingView extends View {
    Rect rect = new Rect();
    Bitmap bitmap = yourHand;

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, null);
        rect.set(x, y, bitmap.getWidth(), bitmap.getHeight());
        invalidate();
    }

    public void onClick() {
        if(rect.contains(event.getX(), event.getY(), && bitmap.getPixel(event.getX() - rect.left, event.getY() - rect.top) != Color.TRANSPARENT) {
          // you know you exactly touched the hand even out of the transparent region
    }
}