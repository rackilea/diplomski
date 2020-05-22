spec = new ImageView[56];
for (i=2; i<=56; i++) {
    String res = "items_r" + Integer.toString(i) + "_c1";
    int resId = getResources().getIdentifier(res, "drawable", getPackageName());
    spec[i] = new ImageView();
    // Drawable image = getResources.getDrawable(resId);
    // spec[i].setImageDrawable(image);
    spec[i].setImageResource(resId);
    Log.e(tag, Boolean.toString(spec[i] == null));
}