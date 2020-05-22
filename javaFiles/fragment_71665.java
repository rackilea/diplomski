public class OverLineTextView extends TextView {

    private Paint paint;

    public OverLineTextView(Context context) {
        super(context);
        init();
    }

    public OverLineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OverLineTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getPaint().measureText(getText().toString());
        canvas.drawLine(getTotalPaddingLeft(), getTotalPaddingTop() + 1,
                getTotalPaddingLeft() + width, getTotalPaddingTop() + 1, paint);
    }
}