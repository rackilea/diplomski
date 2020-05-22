chrono.setOnChronometerTickListener(new OnChronometerTickListener() {

        public void onChronometerTick(Chronometer chronometer) {

            String currentTime= chrono.getText().toString();
            Date date = null;
            try {
                date = new SimpleDateFormat("mm:ss").parse(currentTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String newTime = new SimpleDateFormat("mm:ss").format(date);
            ...