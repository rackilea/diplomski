use  Handler     

 Handler txtsettext = new Handler(Looper.getMainLooper());
                            txtsettext.post(new Runnable() {
                                public void run() {
                                   mPitchView.setText("");
                                   mRollView.setText("");
                                   mAzimuthView.setText("");   

                                }
                            });