GridLayout gv = (GridLayout) findViewById(R.id.gridlayout);
TextView tv = new TextView(context);
tv.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
tv.setText("TextView);
LayoutParams params = new LayoutParams(Set your column and row information as params);
tv.setLayoutParams(params);
gv.addView(tv);