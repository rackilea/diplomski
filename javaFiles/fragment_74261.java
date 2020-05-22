runOnUiThread(new Runnable() {
    @Override
    public void run() { 
        User usrObj = new User();
        if (usrObj.authenticateUser()) {
            Intent mainActivity = new Intent("android.intent.action.Homeview");
            startActivity(mainActivity);
        } else {
            setContentView(R.layout.login); // <- ERROR
            activateLogin();
        }
    }
});