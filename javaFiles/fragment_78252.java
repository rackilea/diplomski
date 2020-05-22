static final ButterKnife.Action<View> changeImageSource = new ButterKnife.Action<View>() {
        @Override public void apply(View view, int index) {
             ImageButton.setImageResource(R.mipmap.imgbtnonclick);
                Handler h =new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        findViewById(R.id.nexticon);
                        ImageButton.setImageResource(R.mipmap.imgbtn);
                    }
                }, 500);
        }
    };