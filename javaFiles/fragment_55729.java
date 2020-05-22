public void LoadCounter() {

    for (int i = 0; i <= 30; i++) {
        final int counter = (30 - i);
        int TIME = 1000 * i;


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txtview.setText(String.valueOf(counter));
            }
        }, TIME);


    }
}