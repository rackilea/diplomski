button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation shrinkButton = AnimationUtils.loadAnimation(MainActivity.this, R.anim.button_animator); //reference the animator
                shrinkButton.setDuration(5000); //dynamically set the duration of your animation
                button.startAnimation(shrinkButton); //start the animation. Since it is inside an onclicklistener, the animation start on a button click event

                shrinkButton.setAnimationListener(new Animation.AnimationListener() { //you could use an AnimationListener to do something on certain event, like at the end of the animation
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) { //you probably want to something onAnimationEnd, otherwise the button will snap back into its original size.

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });