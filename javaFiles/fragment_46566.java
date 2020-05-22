Chronometer chrono  = (Chronometer) findViewById(R.id.chronomete);
chrono.setOnChronometerTickListener(new OnChronometerTickListener(){
        @Override
            public void onChronometerTick(Chronometer chronometer) {
            long time = SystemClock.elapsedRealtime() - chronometer.getBase();
            int h   = (int)(time /3600000);
            int m = (int)(time - h*3600000)/60000;
            int s= (int)(time - h*3600000- m*60000)/1000 ;
            String t = (h < 10 ? "0"+h: h)+":"+(m < 10 ? "0"+m: m)+":"+ (s < 10 ? "0"+s: s);
            chronometer.setText(t);
        }
    });
    chrono.setBase(SystemClock.elapsedRealtime());
    chrono.setText("00:00:00");