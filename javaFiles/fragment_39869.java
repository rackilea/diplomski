animation.setAnimationListener(new AnimationListener() 
        {

            @Override
            public void onAnimationStart(Animation animation) { }

            @Override
            public void onAnimationRepeat(Animation animation) { }

            @Override
            public void onAnimationEnd(Animation animation) 
            {
                v2.setImageResource(R.drawable.some_transparent_image);

            }
        });