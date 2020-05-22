new Handler().postDelayed(new Runnable(){
    @Override
    public void run() {
        runmods(activity);
    }
}, 4000); //alertDialog2 will be displayed for 4 seconds before runmods is called