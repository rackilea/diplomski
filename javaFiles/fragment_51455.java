private Context mContext;
private ArrayList<Draw> mDrawList;
private Paint mPaint;
private Path mPath;
private boolean isErase;
private float mX, mY;
private static final float TOUCH_TOLERANCE = 4;

public EraseDoodleView(Context context) {
    super(context);
    init(context);
}

public EraseDoodleView(Context context, AttributeSet attributeSet) {
    super(context, attributeSet);
    init(context);
}

private void init(Context context) {
    mContext = context;
    mDrawList = new ArrayList<Draw>();
    mPath = new Path();
    setupPaint();
    setLayerType(View.LAYER_TYPE_HARDWARE, mPaint);
}

private void setupPaint() {
    mPaint = new Paint();
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeJoin(Paint.Join.ROUND);
    mPaint.setStrokeCap(Paint.Cap.ROUND);
    mPaint.setFilterBitmap(true);
    mPaint.setAntiAlias(true);
    mPaint.setStrokeWidth(4);
    mPaint.setColor(ContextCompat.getColor(mContext, android.R.color.black));
    if (isErase) {
        mPaint.setXfermode(new PorterDuffXfermode(
                PorterDuff.Mode.CLEAR));
        mPaint.setStrokeWidth(16);
    }
}

public void setErase(boolean isErase) {
    this.isErase = isErase;
    setupPaint();
}

public boolean getErase() {
    return this.isErase;
}

@Override
protected void onDraw(Canvas canvas) {
    for (Draw draw : mDrawList) {
        canvas.drawPath(draw.path, draw.paint);
    }
}

@Override
public boolean onTouchEvent(MotionEvent event) {

    float x = event.getX();
    float y = event.getY();

    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            touchStart(x, y);
            invalidate();
            break;
        case MotionEvent.ACTION_MOVE:
            touchMove(x, y);
            invalidate();
            break;
        case MotionEvent.ACTION_UP:
            touchUp();
            invalidate();
            break;
    }
    return true;
}

private void touchStart(float x, float y) {
    mPath.reset();
    mPath.moveTo(x, y);
    mDrawList.add(new Draw(mPath, mPaint));
    mX = x;
    mY = y;
}
private void touchMove(float x, float y) {
    float dx = Math.abs(x - mX);
    float dy = Math.abs(y - mY);
    if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
        mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
        mX = x;
        mY = y;
    }
}

private void touchUp() {
    mPath.lineTo(mX, mY);
    mPath = new Path();
}


class Draw {
    Path path;
    Paint paint;

    public Draw(Path path, Paint paint) {
        this.paint = paint;
        this.path = path;
    }
}