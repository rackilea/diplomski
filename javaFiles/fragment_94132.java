@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
  int availableHeight = MeasureSpec.getSize(heightMeasureSpec);
  int wantedWidth = availableHeight / 5;

  setMeasuredDimension(wantedWidth, availableHeight);
}