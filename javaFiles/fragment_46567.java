start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            chrono.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
            chrono.start();
        }
    });