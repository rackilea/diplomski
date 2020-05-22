start_timer.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                new AlertDialog.Builder( MainActivity.this )
                        .setMessage( "Are you sure you want to block the selected apps for the set amount of time?" )
                        .setPositiveButton("Yeah man!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("AlertDialog", "Positive");

                                hourint = Integer.valueOf(number_text.getText().toString());

                                minuteint = Integer.valueOf(minute_text.getText().toString());

                                secondint = Integer.valueOf(second_text.getText().toString());

                                Log.i("YourActivity", "Hours: " + hourint);

                                Log.i("YourActivity", "Minutes: " + minuteint);

                                Log.i("YourActivity", "Seconds: " + secondint);

                                Date currenttime = new Date(System.currentTimeMillis());

                                timerstarted = currenttime.getTime();
                                Log.e("This is the current time:  ", timerstarted + "");
                                startimerPreferences = getPreferences(MODE_APPEND);
                                SharedPreferences.Editor starteditor = startimerPreferences.edit();
                                starteditor.putLong("time", timerstarted);
                                starteditor.commit();


                                Date endtime = new Date(System.currentTimeMillis());

                                timerends = endtime.getTime() + (((hourint * 60 * 60) + (minuteint * 60) + (secondint)) * 1000);
                                Log.e("This is the end time:  ", timerends + "");
                                endTimerPreferences = getPreferences(MODE_APPEND);
                                SharedPreferences.Editor endeditor = endTimerPreferences.edit();
                                endeditor.putLong("time", timerends);
                                endeditor.commit();









                                totalTimeCountInMilliseconds = (((hourint * 60 * 60) + (minuteint * 60) + (secondint)) * 1000);      // time count
                                timeBlinkInMilliseconds = 30 * 1000;

                                countDownTimer = new CountDownTimer(totalTimeCountInMilliseconds, 500) {
                                    // 500 means, onTick function will be called at every 500 milliseconds

                                    @Override
                                    public void onTick(long leftTimeInMilliseconds) {

                                        long seconds = leftTimeInMilliseconds / 1000;
                                        mSeekArc.setVisibility(View.INVISIBLE);
                                        start_timer.setVisibility(View.INVISIBLE);
                                        block_button1.setVisibility(View.INVISIBLE);


                                        if (leftTimeInMilliseconds < timeBlinkInMilliseconds) {
                                            // textViewShowTime.setTextAppearance(getApplicationContext(), R.style.blinkText);
                                            // change the style of the textview .. giving a red alert style

                                            if (blink) {
                                                number_text.setVisibility(View.VISIBLE);
                                                minute_text.setVisibility(View.VISIBLE);
                                                second_text.setVisibility(View.VISIBLE);


                                                // if blink is true, textview will be visible
                                            } else {
                                                number_text.setVisibility(View.INVISIBLE);
                                                minute_text.setVisibility(View.INVISIBLE);
                                                second_text.setVisibility(View.INVISIBLE);


                                            }

                                            blink = !blink;         // toggle the value of blink
                                        }

                                        second_text.setText(String.format("%02d", seconds % 60));
                                        minute_text.setText(String.format("%02d", (seconds / 60) % 60));
                                        number_text.setText(String.format("%02d", seconds / 3600));                     // format the textview to show the easily readable format
                                    }


                                    @Override
                                    public void onFinish() {
                                        // this function will be called when the timecount is finished
                                        //textViewShowTime.setText("Time up!");
                                        number_text.setVisibility(View.VISIBLE);
                                        minute_text.setVisibility(View.VISIBLE);
                                        second_text.setVisibility(View.VISIBLE);
                                        mSeekArc.setVisibility(View.VISIBLE);
                                        start_timer.setVisibility(View.VISIBLE);
                                        block_button1.setVisibility(View.VISIBLE);


                                    }

                                }.start();
                            }
                        })
                        .setNegativeButton("Nope!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("AlertDialog", "Negative");
                                dialog.cancel();
                            }
                        })
                        .show();