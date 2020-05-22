RelativeLayout ll = new RelativeLayout(this);

RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
ll.setLayoutParams(params);

TextView textView = new TextView(this);

// textView.;

RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

params1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
params1.addRule(RelativeLayout.CENTER_HORIZONTAL);
textView.setLayoutParams(params1);

// textView.setBottom(TRIM_MEMORY_BACKGROUND);
textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 48);
textView.setText("hello");

ll.addView(textView);

setContentView(ll);