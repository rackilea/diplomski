private Handler mHandler = new Handler();

//code to make text appear...

    mHandler.postDelayed(makeTextDisapear , 3000); // Replace 3000 with the number of milliseconds you want the text to display.

    private Runnable makeTextDisapear = new Runnable() {
            public void run() {
                // code to make text dissapear

                }
            };