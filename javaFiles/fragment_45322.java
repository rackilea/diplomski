case MotionEvent.ACTION_UP:                                                
    new Timer().schedule(new TimerTask() {

                    @Override
                    public void run() {

                        MainActivity.this.runOnUiThread(new Runnable() {

                            public void run() {
                                myImage.scrollTo((int) mx, 0);
                                myImage.invalidate();

                            }
                        });

                        if (mx > 0) {
                            mx -= 1;
                        } else {
                            cancel();
                        }



                    }
                }, 100,10);