TranslateAnimation translate = new TranslateAnimation(0, mDestLoc1[0]-mSrcLoc1[0], 0, mDestLoc1[1]-mSrcLoc1[1]);                   
     translate.setDuration(2000);
     translate.setAnimationListener(new AnimationListener(){

         @Override
         public void onAnimationStart(Animation animation) {}

         @Override
         public void onAnimationEnd(Animation animation) {
             RelativeLayout.LayoutParams par = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
             par.topMargin = mDestLoc1[1]-mSrcLoc1[1];
             par.leftMargin = mDestLoc1[0]-mSrcLoc1[0];
             view.setLayoutParams(par);              
         }

         @Override
         public void onAnimationRepeat(Animation animation) {}

     });

     view.startAnimation(translate);