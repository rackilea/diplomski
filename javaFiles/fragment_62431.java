wobble.setAnimationListener(new AnimationListener(){

   @Override
   public void onAnimationStart(Animation animation){}

   @Override
   public void onAnimationRepeat(Animation animation){}

   @Override
   public void onAnimationEnd(Animation animation){
           startActivity(new Intent(YourCurrentActivity.this, CityRendActivity.class)); // if the code is in Fragment, then replace YourCurrentActivity.this by getActivity()
   }
});