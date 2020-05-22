public class DrawLine extends View {

    private Path path = new Path();
    private Paint paint = new Paint();
    private int currentColor = Color.BLACK;
    private List<Path> paths = new ArrayList<Path>();
    private List<Integer> colors = new ArrayList<Integer>();
    private float x;
    private float y;

    public DrawLine(Context context) {
        super(context);
        init(context);
    }

    public DrawLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DrawLine(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public void init(Context context) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setColor(currentColor);
    }

    public void changeColor(int color) {
        currentColor = color;
        path = new Path();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int x = 0; x < paths.size(); x++) {
            paint.setColor(colors.get(x));
            canvas.drawPath(paths.get(x), paint);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                path.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                x = event.getX();
                y = event.getY();
                path.lineTo(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                paths.add(path);
                colors.add(currentColor);
                invalidate();
                break;
        }
        invalidate();
        return true;
    }
}