ImageView img_animation = (ImageView) findViewById(R.id.img_animation);

    TranslateAnimation animation = new TranslateAnimation(0.0f, 400.0f,
            0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
    animation.setDuration(5000);  // animation duration 
    animation.setRepeatCount(5);  // animation repeat count
    animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
    //animation.setFillAfter(true);      

    img_animation.startAnimation(animation);  // start animation