stop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            timeWhenStopped = chrono.getBase() - SystemClock.elapsedRealtime();
            chrono.stop();

        }
    });