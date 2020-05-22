static int green = ResourcesCompat.getColor(getResources(), R.color.colorGreen, null));


static void starLight(RatingBar ratingBar) {

 Drawable progress = ratingBar.getProgressDrawable();
        if (whole == 1) {
            DrawableCompat.setTint(progress, green);
...}