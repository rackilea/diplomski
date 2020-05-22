Button onetwothree = (Button) findViewById(R.id.onetwothree);
    onetwothree.setOnTouchListener(new View.OnTouchListener() {

        Handler handler = new Handler();

        int numberOfTaps = 0;
        long lastTapTimeMs = 0;
        long touchDownMs = 0;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touchDownMs = System.currentTimeMillis();
                    break;
                case MotionEvent.ACTION_UP:
                    handler.removeCallbacksAndMessages(null);
                    if ((System.currentTimeMillis() - touchDownMs) > ViewConfiguration.getTapTimeout()) {
                        //it was not a tap

                        numberOfTaps = 0;
                        lastTapTimeMs = 0;
                        break;
                    }

                    if (numberOfTaps > 0
                            && (System.currentTimeMillis() - lastTapTimeMs) < ViewConfiguration.getDoubleTapTimeout()) {
                        numberOfTaps += 1;
                    } else {
                        numberOfTaps = 1;
                    }
                    lastTapTimeMs = System.currentTimeMillis();

                    if (numberOfTaps == 1) {
                        handler.postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                if (txtScreen.getText().toString() == "") {
                                    txtScreen.setText("1");
                                } else txtScreen.append("1");
                            }
                        }, ViewConfiguration.getDoubleTapTimeout());



                    }else if (numberOfTaps == 2) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (txtScreen.getText().toString() == "") {
                                    txtScreen.setText("2");
                                } else txtScreen.append("2");
                            }
                        }, ViewConfiguration.getDoubleTapTimeout());

                    } else if (numberOfTaps == 3) {
                                if (txtScreen.getText().toString() == "") {
                                    txtScreen.setText("3");
                                } else txtScreen.append("3");
                    }
            }

            return true;
        }
    });