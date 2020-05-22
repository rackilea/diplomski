public ViewingWindow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attr, defStyle);

        greenBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.green_icon);
        redBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.red_icon);
    }