TextView txt;
txt.setText("A");

txt = (TextView) findViewById(R.id.custom_font);
Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Grundschrift.ttf");
txt.setTypeface(font);