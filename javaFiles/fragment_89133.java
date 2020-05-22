view.setText("something");
view.postDelayed(new Runnable(){
    public void run(){
        view.setText("somethingelse.");
    }
}, 200);