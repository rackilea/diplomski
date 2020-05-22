@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth / 2, parentHeight);
        //Since you are attatching it to the window use window layout params.
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(parentWidth / 2,
                parentHeight);
        this.setLayoutParams(layoutParams);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("display", "filling...");
    }