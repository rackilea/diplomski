final Handler h = new Handler();

h.postDelayed(new Runnable() {

    private int counter = 0;

    public void run() {

        // Update your text view here
        ...

        if (++counter < 5) {
            h.postDelayed(this, 500);
        }
    }
}, 500);