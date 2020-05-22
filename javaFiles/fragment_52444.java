TranslateAnimation animation = new TranslateAnimation(answer,  answer, 0,  height * -1); // xfrom , xto, y from,y to
animation.setDuration(5000);
Floater0.setVisibility(View.VISIBLE); //show it
Floater0.startAnimation(animation);
animation.setAnimationListener(new Animation.AnimationListener() {

@Override
public void onAnimationStart(Animation animation) {
}

@Override
public void onAnimationRepeat(Animation animation) {
}

@Override
public void onAnimationEnd(Animation animation) {
    if (AdPlayer0.isPlaying()) {
        Floater0.startAnimation(animation);
    }
}