imageView.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        mScaleGestureDetector.onTouchEvent(event);

        bitmap = imageView.getDrawingCache();
        int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());
        String text = "x = " + event.getX() + ", y = " + event.getY();
        Log.d("Position", text);
        int redValue = Color.red(pixel);
        int greenValue = Color.green(pixel);
        int blueValue = Color.blue(pixel);

        return false;
    }
});