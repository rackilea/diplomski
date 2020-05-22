public class RoundedBackgroundSpan extends ReplacementSpan
{

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return 0;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint)
    {
        RectF rect = new RectF(x, top, x + text.length(), bottom);
        paint.setColor(Color.CYAN);
        canvas.drawRoundRect(rect, 20, 20, paint);
        paint.setColor(Color.WHITE);
        canvas.drawText(text, start, end, x, y, paint);
    }
}