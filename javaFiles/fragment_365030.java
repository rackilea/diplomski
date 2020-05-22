//Button 1 Start On Click
    final CountDown buttonOneTimer = new CountDown(15000,1000,buttonOne);
    buttonOne.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            buttonOneTimer.start();
        }
    });