//if text view2 is below textview one and text view 2 is on the right of text view one
int topMargin=textview2_top_margin - textview1_top_margin
int leftMargin=textview2_left_margin - textview1_left_margin

public void animation() {
  Animation animation = new TranslateAnimation(left_margin, 0, topMargin, 0);
  animation.setDuration(1000);
  controlToAnimate.startAnimation(animation);
 }