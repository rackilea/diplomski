myRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {

            if(fromUser)
            setRatingWithAnimation(v);

        }
    });


public void setRatingWithAnimation(float ratingWithAnimation) {

    ObjectAnimator
            .ofFloat(myRatingBar,"Rating",0,ratingWithAnimation)
            .setDuration(1000)
            .start();

}