private int finalHeight, finalWidth;
         @Override
            protected void onCreate(Bundle savedInstanceState) {
.....
        final ImageView iv = (ImageView)findViewById(R.id.scaled_image);
        final TextView tv = (TextView)findViewById(R.id.size_label);
        ViewTreeObserver vto = iv.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                iv.getViewTreeObserver().removeOnPreDrawListener(this);
                finalHeight = iv.getMeasuredHeight();
                finalWidth = iv.getMeasuredWidth();
                tv.setText("Height: " + finalHeight + " Width: " + finalWidth);
                return true;
            }
        });