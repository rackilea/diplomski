Handler h = new Handler();
int delay = 10 * 1000;

h.postDelayed(new Runnable(){
    public void run(){

        // This portion of code runs each 10s.

        h.postDelayed(this, delay);
    }
}, delay);