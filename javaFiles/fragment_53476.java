private int counter = 0; // global var
private int random = 0; // global var

final Handler handler = new Handler();

handler.post(r);

final Runnable r = new Runnable() {
    public void run() {
        //generate random number and do you work
        random = (int)(Math.random() * 50 + 1);
        counter++;
        // call Runnable again after 1 sec if counter <= 3000 (50 min)
        if (counter <= 3000){ // 3000 = 50min
            handler.postDelayed(this, 1000); // 1000 = 1 sec
        }
    }
};