class TestView extends View { 
    private Paint circle = new Paint();
    private boolean isPop = false;
    private Runnable everyThreeSeconds = new Runnable() {
        public void run() {
            // Do something spiffy like...
            isPop = !isPop;
            invalidate();

            // Don't forget to call you next three second interval!
            postDelayed(everyThreeSeconds, 3000);
        }
    };

    public TestView(Context context) {
        this(context, null);
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        circle.setColor(Color.BLUE);
        post(everyThreeSeconds);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);

        if (isPop){
            canvas.drawCircle(100, 100, 40, circle);
        }
    }
}