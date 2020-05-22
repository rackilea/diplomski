@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    // TODO Auto-generated method stub
    super.onMeasure(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
}

@Override
protected void onDraw(Canvas canvas) {
    // preprocess your text
    canvas.drawText(...);
}