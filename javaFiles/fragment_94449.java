LinearLayout layout =new LinearLayout(this);
layout.setOrientation(LinearLayout.VERTICAL);
layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,     LinearLayout.LayoutParams.WRAP_CONTENT);
lparams.setMargins(0, 10, 0, 10);
lparams.gravity= Gravity.CENTER;

setContentView(layout);

TextView fimText = new TextView(this);
fimText.setLayoutParams(lparams);
fimText.setText(String.valueOf(layout.getHeight()));
layout.addView(fimText, lparams);