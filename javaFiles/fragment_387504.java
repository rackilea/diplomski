public void startWatch(View V){
    new Thread(new Runnable() {
        @Override
        public void run() {

            final TextView time = (TextView) findViewById(R.id.display);

            long seconds=1;
            int hour,minute,second;
            String h,m,s,text;

            int y=0;

            for(;;seconds++) {

                long temp;
                temp = seconds;
                delay(1000);

                hour = (int) (temp / 3600);
                h = (hour > 9) ? "" : "0";
                temp = temp % 3600;

                minute = (int) (temp / 60);
                m = (minute > 9) ? "" : "0";
                temp = temp % 60;

                second = (int) (temp / 1);
                s = (second > 9) ? "" : "0";
                temp = temp % 1;

                text = h + hour + ":" + m + minute + ":" + s + second;

                final String finalText = text;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time.setText(finalText);
                    }
                });
            }
        }
    }).start();
}