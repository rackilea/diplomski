public class OverlayView extends ListView {
  private RectF mRect;
  private Rect mSrcRect;
  private Paint mPaint;

  private Canvas mCanvas;
  private Bitmap mBitmap;
  private float mY;
  private float mItemHeight;

  public OverlayView(Context context) {
    super(context);

    initOverlay();
  }

  public OverlayView(Context context, AttributeSet attrs) {
    super(context, attrs);

    initOverlay();
  }

  public OverlayView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);

    initOverlay();
  }

  private void initOverlay() {
    // DO NOT DO THIS use attrs
    final Resources res = getResources();
    mY = res.getDimension(R.dimen.overlay_y);
    mItemHeight = res.getDimension(R.dimen.item_height);
    //
    mRect = new RectF();
    mSrcRect = new Rect();
    mPaint = new Paint();

    ColorMatrix colorMatrix = new ColorMatrix();
    colorMatrix.setSaturation(0);
    mPaint.setColorFilter( new ColorMatrixColorFilter(colorMatrix) );
  }

  @Override
  public void draw(Canvas canvas) {
    super.draw(mCanvas);
    canvas.drawBitmap(mBitmap, 0, 0, null);

    canvas.drawBitmap(mBitmap, mSrcRect, mRect, mPaint);
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);

    mRect.set(0, mY, w, mY + mItemHeight);
    mRect.roundOut(mSrcRect);

    mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
    mCanvas = new Canvas(mBitmap);
  }
}