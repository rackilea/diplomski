public class GaugeView extends View {

    private Paint arcPaint;

    public GaugeView(Context context) {
        super(context);
        initialize();
    }

    public GaugeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public GaugeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(15f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        int arcCenterX = width - 10;
        int arcCenterY = height - 10;

        final RectF arcBounds = new RectF(arcCenterX - 100, arcCenterY - 100, arcCenterX + 100, arcCenterY + 100);


        // Draw the arc
        canvas.drawArc(arcBounds, 180f, 20f, false, arcPaint);
        arcPaint.setColor(Color.DKGRAY);
        canvas.drawArc(arcBounds, 200f, 40f, false, arcPaint);
        arcPaint.setColor(Color.GRAY);
        canvas.drawArc(arcBounds, 2400f, 30f, false, arcPaint);

        // Draw the pointers
        final int totalNoOfPointers = 20;
        final int pointerMaxHeight = 25;
        final int pointerMinHeight = 15;

        int startX = arcCenterX - 120;
        int startY = arcCenterY;
        arcPaint.setStrokeWidth(5f);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);

        int pointerHeight;
        for (int i = 0; i <= totalNoOfPointers; i++) {
            if(i%5 == 0){
                pointerHeight = pointerMaxHeight;
            }else{
                pointerHeight = pointerMinHeight;
            }
            canvas.drawLine(startX, startY, startX - pointerHeight, startY, arcPaint);
            canvas.rotate(90f/totalNoOfPointers, arcCenterX, arcCenterY);
        }
    }
}