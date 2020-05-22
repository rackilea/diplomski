View v = new View(this);
RelativeLayout.LayoutParams viewLp = new LayoutParams(LayoutParams.FILL_PARENT, 1);
viewLp.addRule(RelativeLayout.BELOW, imageViewID);
viewLp.addRule(RelativeLayout.CENTER_HORIZONTAL);
viewLp.setMargins(0, 5, 0, 0);

v.setLayoutParams(viewLp);
v.setBackgroundColor(0x808080);

rl.addView(v);