private View addImageViewWithText(Bitmap bitmap, String text) {
    LinearLayout layout = new LinearLayout(this);// 'this' is a Context instance
    layout.setOrientation(LinearLayout.VERTICAL);

    ImageView imageView = new ImageView(this);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    params.weight = 1;
    imageView.setLayoutParams(params);
    imageView.setImageBitmap(bitmap);

    layout.addView(imageView);

    TextView textView = new TextView(this);
    params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    //params.gravity = Gravity.CENTER;
    textView.setLayoutParams(params);
    textView.setText(text);

    layout.addView(textView);

    return layout;
}