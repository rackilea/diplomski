Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.setBackgroundResource(R.drawable.button_bg_rounded_corners);
                updateQuestion();

            }
        }, 10000);