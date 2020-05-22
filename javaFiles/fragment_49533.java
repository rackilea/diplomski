circle2 = (ImageView) findViewById(R.id.circle2);
    ScaleAnimation fade_in =  new ScaleAnimation(0f, 1f, 0f, 1f, 
    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    fade_in.setDuration(1000);     // animation duration in milliseconds
    fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
    circle2.startAnimation(fade_in);