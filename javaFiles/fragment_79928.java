if(timerstarted > 0)
    {
        if(reopened <timerends){
            //start countdown timer with new time.
            //set countdowntime to timerends-reopen.

            newtotalTimeCountInMilliseconds = timerends-reopened;
            countDownTimer = new CountDownTimer(newtotalTimeCountInMilliseconds, 500) {
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
    }