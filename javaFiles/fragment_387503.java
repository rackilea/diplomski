public void startWatch(View V){
    final TextView time = (TextView) findViewById(R.id.display);
    final long[] seconds = {1};
    final int[] hour = new int[1];
    final int[] minute = new int[1];
    final int[] second = new int[1];
    final String[] h = new String[1];
    final String[] m = new String[1];
    final String[] s = new String[1];
    final String[] text = new String[1];

    int y=0;

    final Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            long temp = seconds[0];

            hour[0] = (int) (temp/3600);
            h[0] =(hour[0] >9)?"":"0";
            temp = temp % 3600;

            minute[0] = (int) (temp/60);
            m[0] =(minute[0] >9)?"":"0";
            temp = temp % 60;

            second[0] = (int) (temp/1);
            s[0] =(second[0] >9)?"":"0";
            temp = temp % 1;

            text[0] = h[0] + hour[0] +":"+ m[0] + minute[0] +":"+ s[0] + second[0];

            time.setText(text[0]);

            seconds[0]++;

            handler.postDelayed(this, 1000);
        }
    };
    handler.postDelayed(runnable, 1000);
}