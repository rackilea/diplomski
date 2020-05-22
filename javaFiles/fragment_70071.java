FrameLayout frame = new FrameLayout(context);

FrameLayout.LayoutParams flParams = new FrameLayout.LayoutParams(
    ViewGroup.LayoutParams.WRAP_CONTENT, 
    ViewGroup.LayoutParams.WRAP_CONTENT, 
    Gravity.CENTER_HORIZONTAL
);

Loading loading = new Loading(this, inputStream);
loading.setLayoutParams(flParams);
frame.addView(loading);
setContentView(frame);