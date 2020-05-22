private class Rectangle extends View{
    Paint paint = new Paint();

    public Rectangle(Context context) {
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas) {
        paint.setColor(Color.GREEN);
        Rect rect = new Rect(20, 56, 200, 112);
        canvas.drawRect(rect, paint );
    }
 }