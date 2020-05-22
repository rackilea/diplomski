CountDownTimer firstTimer = new CountDownTimer(5000, 1000) {  //fall registration timer

        @Override
        public void onTick(long millisUntilFinished) {
            //if there is movement before 5 seconds pass cancel the timer
            if (abs(mAccel) > 2.0f) {
                Toast toast = Toast.makeText(getApplicationContext(),
                              "Fall not Detected", Toast.LENGTH_SHORT);
                toast.show();
                firstTimer.cancel();
            }
        }

        @Override
        public void onFinish() {
            Toast toast = Toast.makeText(getApplicationContext(),
                          "Fall Detected!", Toast.LENGTH_SHORT);
            toast.show();
            secondTimer.start();
        }
    };

    CountDownTimer secondTimer = new CountDownTimer(30*1000, 1000) {
    //fall confirmation timer

        @Override
        public void onTick(long millisUntilFinished) {
            textView2.setText("" + millisUntilFinished / 1000);
        }

        @Override
        public void onFinish() {
            Toast toast = Toast.makeText(getApplicationContext(),
            "Fall Registered!", Toast.LENGTH_LONG);
            toast.show();
        }
    };


@Override
public void onSensorChanged(SensorEvent event) {

    if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
        mGravity = event.values.clone();
        float x = mGravity[0];
        float y = mGravity[1];
        float z = mGravity[2];
        mAccelLast = mAccelCurrent;
        mAccelCurrent = (float) Math.sqrt(x * x + y * y + z * z);
        float delta = mAccelCurrent - mAccelLast;
        mAccel = mAccel * 0.9f + delta;
        mAccel = abs(mAccel);
        textView.setText("a:"+mAccel);
        if (abs(mAccel) > 5.0f) { // Shake detection
            mTimer.schedule(new TimerTask() { 
            //start after 2 second delay to make acceleration values "rest"

                @Override
                public void run() {
                    firstTimer.start();
                }

            }, 2000);
        }
    }
}