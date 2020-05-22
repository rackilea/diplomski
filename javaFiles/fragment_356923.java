public class MyView extends View {
    Path mylines = new Path();
    private Paint redPaint;
    private Paint greenPaint;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context) {
        super(context, null);
        init();
    }

    private void init() {
        redPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        redPaint.setStyle(Paint.Style.STROKE);
        redPaint.setColor(0xffff0000);
        redPaint.setStrokeWidth(5);

        greenPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        greenPaint.setStyle(Paint.Style.STROKE);
        greenPaint.setARGB(255, 0, 255, 0);
        greenPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(10, 30, 200, 200, redPaint);
        canvas.drawCircle(300, 300, 250, redPaint);

        mylines.moveTo(0, 0);
        mylines.lineTo(200, 50);
        mylines.lineTo(300, 150);
        mylines.lineTo(400, 250);
        mylines.lineTo(500, 300);

        canvas.drawPath(mylines, greenPaint);

    }
}