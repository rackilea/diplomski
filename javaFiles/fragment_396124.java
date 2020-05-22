protected void onMeasure( int widthMeasureSpec, int heightMeasureSpec ) {
    int parentViewWidth = MeasureSpec.getSize( widthMeasureSpec );
    int parentViewHeight = MeasureSpec.getSize( heightMeasureSpec );
    // ... take into account the parent's size as needed ...
    super.onMeasure(
        MeasureSpec.makeMeasureSpec( bitmap.width(), MeasureSpec.EXACTLY ), 
        MeasureSpec.makeMeasureSpec( bitmap.height(), MeasureSpec.EXACTLY ) );
}