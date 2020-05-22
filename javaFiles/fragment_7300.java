else {

                    if(min.get()== 1) {
                        mCount.setText("60 Sec");
                        handler.postDelayed(this, 500);
                    }
                    else if(min.get() == 0){
                        mCount.setText("30 Sec");
                        handler.postDelayed(this, 500);
                    }
                    else
                        mCount.setText("0 Sec");
                        min.getAndDecrement();
                }