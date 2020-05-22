public class FractionDrawable extends Drawable {
    private Paint mPaint;
    private float mFraction;

    public FractionDrawable(float fraction) {
        mPaint = new Paint();
        setFraction(fraction);
    }

    public void setFraction(float fraction) {
        mFraction = fraction;
        invalidateSelf();
    }

    @Override
    public void draw(Canvas canvas) {
        Rect b = getBounds();
        mPaint.setColor(0xff00aa00);
        float x = b.width() * mFraction;
        canvas.drawRect(0, 0, x, b.height(), mPaint);
        mPaint.setColor(0xffaa0000);
        canvas.drawRect(x, 0, b.width(), b.height(), mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}