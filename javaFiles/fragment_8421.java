Button submit;
   TextView timerText;
   EditText editTextTime;
   CountdownTimer yourTimer;
   String  timeString;
   int time;

  submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

     timeString = String.valueOf(editTextTime.getText());
     time = Integer.valueOf(timeString);


        }
    });


    yourTimer = new CountDownTimer(time, 1000) {

    @Override
    public void onTick(long millisUntilFinished) {


        int seconds = (int) millisUntilFinished / 1000;
        int minutes = seconds / 60;
        seconds %= 60;
        minutes %= 60;


        if (seconds < 10 && seconds >= 1) {
            timerText.setText("" + seconds);
        }
    }

    @Override
    public void onFinish() {

    }
}.start();