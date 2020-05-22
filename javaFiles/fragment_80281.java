long previousTime = 0;

protected final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;

            if (shake > 12) {
              //Fade in text if difference between previous and current time is > 2 seconds
              if (System.currentTimeMillis() - previousTime > 2000) {
                previousTime = System.currentTimeMillis();
                //Use AlphaAnimation
                Animation fadeInAnimation = new AlphaAnimation(0, 1);
                fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        int randomNum = new Random().nextInt(answersArray.length);
                        ball_text.setText(answersArray[randomNum]);
                        ball_text.setVisibility(View.VISIBLE);
                    }
                    @Override
                    public void onAnimationEnd(Animation animation) {}
                    @Override
                    public void onAnimationRepeat(Animation animation) {}
                });
                fadeInAnimation.setInterpolator(new DecelerateInterpolator());
                fadeInAnimation.setDuration(1000);
                ball_text.startAnimation(fadeInAnimation);
                /*
                //This should work, but it doesn't, I'll prob tinker with it on some weekend, I'll update the answer if I figure out the issue
                ball_text.animate()
                   .withStartAction(new Runnable() {
                            @Override
                            public void run() {
                                int randomNum = new Random().nextInt(answersArray.length);
                                ball_text.setText(answersArray[randomNum]);
                                ball_text.setAlpha(0f);
                                ball_text.setVisibility(View.VISIBLE);
                            }
                        })
                   .alpha(1f)
                   //Fade in over a duration of 1 second
                   .setDuration(1000)
                   .start()

                */
              } else {
                //If it's less than 2 seconds since last shake, inform user to wait
                //For eg,
                Toast.makeText(context, "Wait mate", Toast.LENGTH_SHORT).show();
              }
            }
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };