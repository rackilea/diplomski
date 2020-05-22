Drawable d = getResources().getDrawable(R.drawable.ic_launcher);
Button one = new Button(this);
// mediocre
one.setBackgroundDrawable(d);
Button two = new Button(this);
// better
two.setBackgroundResource(R.drawable.ic_launcher);