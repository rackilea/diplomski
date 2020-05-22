ShapeDrawable sd = new ShapeDrawable(new RectShape());
sd.setIntrinsicHeight(1);
Paint fgPaintSel = sd.getPaint();
fgPaintSel.setARGB(255, 0, 0, 0);
fgPaintSel.setStyle(Paint.Style.STROKE);
fgPaintSel.setPathEffect(new DashPathEffect(new float[]{5, 10}, 0));

LinearLayout linearLayout = (LinearLayout) findViewById(R.id.main);
linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE | LinearLayout.SHOW_DIVIDER_END);
linearLayout.setDividerDrawable(sd);