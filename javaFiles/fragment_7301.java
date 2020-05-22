final TextView mCount = (TextView) findViewById(R.id.count);
        final Handler handler = new Handler();
        final AtomicInteger min = new AtomicInteger(4);
        final Runnable counter = new Runnable() {
            @Override
            public void run() {

                if (min.get() > 1) {
                    mCount.setText(Integer.toString(min.get())+" min");
                    handler.postDelayed(this, 1000);
                    min.getAndDecrement();
                } else {

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

            }
        };
        handler.postDelayed(counter, 0);