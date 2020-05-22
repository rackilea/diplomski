MyChronometer.setOnChronometerTickListener(new OnChronometerTickListener()
        {

            public void onChronometerTick(Chronometer p1)
            {

                if (MyChronometer.getText().toString().contains(MyEditText.getText().toString()))
                {
                    //Do something
                }
            }
    });