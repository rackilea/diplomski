@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
{
    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
    int heightSize = MeasureSpec.getSize(heightMeasureSpec);

    final int width = MeasureSpec.getSize(widthMeasureSpec);
    int height;
    int desiredHeight = Math.round(width * RATIO);

    if (heightMode == MeasureSpec.EXACTLY) {
        height = heightSize;
    } else if (heightMode == MeasureSpec.AT_MOST) {
        height = Math.min(desiredHeight, heightSize);
    } else {
        height = desiredHeight;
    }

    setMeasuredDimension(width, height);
}