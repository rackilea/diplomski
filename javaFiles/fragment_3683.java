public class Rectangle extends View {
    private final Paint mBackPaint = new Paint();
    private final Paint mRedPaint = new Paint();
    private int mSideRectWidth = 10;

    public Rectangle(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBackPaint.setColor(Color.BLACK);
        mRedPaint.setColor(Color.RED);
        mSideRectWidth = context.getResources().getDimensionPixelSize(R.dimen.side_rect_width);
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() == 0)
            return;

        setBackgroundColor(Color.GRAY);

        //draw black line
        int boxWidth = (getWidth() - 2 * mSideRectWidth) / 7;
        for (int i = 0; i < 7; i++) {
            canvas.drawLine(mSideRectWidth + boxWidth * i, 0, mSideRectWidth + boxWidth * i, getHeight(), mBackPaint);
        }

        //draw left rectangle
        canvas.drawRect(0, 0, mSideRectWidth, getHeight(), mRedPaint);

        //draw right rectangle
        canvas.drawRect(getWidth() - mSideRectWidth, 0, getWidth(), getHeight(), mRedPaint);
    }
}