public class DrawView extends View {
public Paint mPaint;
private Paint mPaint1;
private Paint mPaint2;

private Bitmap mBitmap;
private Canvas mCanvas;
private Path mPath;
private Paint mBitmapPaint;

public DrawView(Context context, AttributeSet attrs) {
    super( context,  attrs);

    mPath = new Path();
    mBitmapPaint = new Paint(Paint.DITHER_FLAG);
    mPaint = new Paint();
    mPaint.setAlpha(0x80);
    mPaint.setAntiAlias(true);
    mPaint.setDither(true);
    mPaint.setColor(0x44000000);
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeJoin(Paint.Join.ROUND);
    mPaint.setStrokeCap(Paint.Cap.BUTT);
    mPaint.setStrokeWidth(5);

}

@Override
protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
    mCanvas = new Canvas(mBitmap);

}

@Override
protected void onDraw(Canvas canvas) {
    canvas.drawColor(0xFF00B8F5);

    canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
}

private float mX, mY;
private static final float TOUCH_TOLERANCE = 4;

private void touch_start(float x, float y) {
    mPath.reset();
    mPath.moveTo(x, y);
    mX = x;
    mY = y;
    //mCanvas.drawPoint(x, y, mPaint);

}

private void touch_move(MotionEvent event) {
    float x = event.getX();
    float y = event.getY();
    Path npath=new Path();
    npath.moveTo(mX, mY);
    npath.lineTo( x ,y );
    mX=x;
    mY=y;
    mCanvas.drawPath(npath, mPaint);
    npath.reset();
    //Log.e("","sto disegando");
}

private void touch_up() {

}

@Override
public boolean onTouchEvent(MotionEvent event) {
    float x = event.getX();
    float y = event.getY();

    switch (event.getAction()) {
    case MotionEvent.ACTION_DOWN:
        touch_start(x, y);
        invalidate();
        break;
    case MotionEvent.ACTION_MOVE:
        touch_move(event);
        invalidate();
        break;
    case MotionEvent.ACTION_UP:
        touch_up();
        invalidate();
        break;
    }
    return true;
}
}