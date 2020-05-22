for (int i = 0; i < 4; i++) {
    markeringspilen.postDelayed(new Runnable() {
        public void run() {
            ImageView markeringspilen = (ImageView) findViewById(R.id.markeringspil);
            markeringspilen.setVisibility(View.VISIBLE);
        }
    }, 4000*i);
    markeringspilen.postDelayed(new Runnable() {
        public void run() {
            ImageView markeringspilen = (ImageView) findViewById(R.id.markeringspil);
            markeringspilen.setVisibility(View.INVISIBLE);
        }
    }, 4000*i+2000);
}