private void flingCardAway(){

    View cardContainer = findViewById(R.id.card_container);
    ViewCompat.setTranslationZ(cardContainer, 1.0f);

    AnimationSet anim = new AnimationSet(true);

    RotateAnimation rotate1 = new RotateAnimation(0,-45, Animation.RELATIVE_TO_SELF,0.5f , Animation.RELATIVE_TO_SELF,0.5f );
    rotate1.setStartOffset(10);
    rotate1.setDuration(500);
    anim.addAnimation(rotate1);

    TranslateAnimation trans1 =  new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -0.2f, Animation.RELATIVE_TO_PARENT, -0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
    trans1.setDuration(100);
    anim.addAnimation(trans1);

    TranslateAnimation trans2 =  new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -0.1f, Animation.RELATIVE_TO_PARENT, -0.1f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
    trans2.setStartOffset(100);
    trans2.setDuration(100);
    anim.addAnimation(trans2);

    AlphaAnimation opacity1 = new AlphaAnimation(1.0f, 0.0f);
    opacity1.setDuration(300);
    opacity1.setStartOffset(300);
    anim.addAnimation(opacity1);

    cardContainer.setAnimation(anim);


    mCardFrame.removeAllViews();

}