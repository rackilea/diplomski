...
     // format the string of timer2 to add a zero when it is a single digit so that it matches with the date format you have used ie HH:mm
      @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {

                TextView textView = (TextView)findViewById(R.id.timetext);
                textView.setText("Hour: " + hour + "   Minutes:" + minute );

                // String Shour = Integer.toString(hour);
                // String Sminute = Integer.toString(minute);
                final String time2 = String.format(Locale.getDefault(),"%02d:%02d", hour, minute);
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");

                final String time = format.format(calendar.getTime());
                Toast.makeText(getApplicationContext(), "vlaue is "+time, Toast.LENGTH_LONG).show();

                Timer t = new Timer();
                t.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        if(time.equals(time2)){
                            // Toast.makeText(getApplicationContext(), "SAME VALUE: "+time, Toast.LENGTH_LONG).show();
                            runOnUiThread(new Runnable() {
                              public void run() {
                                 Toast.makeText(getApplicationContext(), "SAME VALUE: "+time, Toast.LENGTH_LONG).show();
                              }
                            }
                        }
                        else{

                        }
                    }
                },0,1000);
            }