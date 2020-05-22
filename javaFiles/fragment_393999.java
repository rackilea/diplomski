private void startAnimation(final ImageView imageView, int position)
    {
        // TODO Auto-generated method stub
        int iDuration = 500;
        final ScaleAnimation scaleAnimationIN = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, Animation.RELATIVE_TO_SELF, (float) 0.5,
                Animation.RELATIVE_TO_SELF, (float) 0.5);
        final ScaleAnimation scaleAnimationOUT = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, Animation.RELATIVE_TO_SELF, (float) 0.5,
                Animation.RELATIVE_TO_SELF, (float) 0.5);
        scaleAnimationIN.setStartOffset(8000 + position * 2000);
        scaleAnimationIN.setDuration(iDuration);
        scaleAnimationOUT.setStartOffset(0);
        scaleAnimationOUT.setDuration(iDuration);
        scaleAnimationIN.setAnimationListener(new AnimationListener()
        {

            @Override
            public void onAnimationStart(Animation animation)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                // TODO Auto-generated method stub
                imageView.startAnimation(scaleAnimationOUT);
            }
        });
        scaleAnimationOUT.setAnimationListener(new AnimationListener()
        {

            @Override
            public void onAnimationStart(Animation animation)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                // TODO Auto-generated method stub
                imageView.startAnimation(scaleAnimationIN);
            }
        });
        imageView.startAnimation(scaleAnimationIN);

    }