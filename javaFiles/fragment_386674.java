LinearLayout linear = (LinearLayout) findViewById(R.id.left);
    TextView textView = new TextView(this);
    textView.setText("Test Right 1");
    textView.setTextSize(32);
    LinearLayout.LayoutParams tParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    linear.addView(textView, tParams);

    ImageView imageView = new ImageView(this);
    imageView.setImageResource(R.mipmap.img);
    imageView.setAdjustViewBounds(true); // This is the trick
    LinearLayout.LayoutParams iParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    linear.addView(imageView, iParams);