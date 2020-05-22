public class Draw extends View {
Paint paint;

public Draw(Context context) {
    super(context);
    paint = new Paint(Paint.ANTI_ALIAS_FLAG);
}

@Override
protected void onDraw(Canvas canvas) {
    paint.setColor(Color.BLUE);
    canvas.drawCircle(120, 120, 40, paint);
    super.onDraw(canvas);
}}