float left = getScreenSize().x * 0.10f;
float top = getScreenSize().y * 0.10f;

canvas.drawBitmap(pasteImage, left, top, null);

private float getScreenSize() {
     WindowManager windowManager = (WindowManager) getContext.getSystemService(Context.WINDOW_SERVICE);
     Display display = windowManager.getDefaultDisplay();
     Display display = getWindowManager().getDefaultDisplay();
     Point size = new Point();
     display.getSize(size);
     return size;
}