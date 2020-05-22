private static final String PENDING_LAUNCH_KEY = "PENDING_LAUNCH";
private boolean pendingLaunch;
private boolean activityPaused;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (savedInstanceState != null) {
        pendingLaunch = savedInstanceState.getBoolean(PENDING_LAUNCH_KEY);
    }

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_load_screen);

    if (!pendingLaunch) {
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();
    }
}

@Override
protected void onResume() {
    activityPaused = false; 

    if (pendingLaunch) {
        pendingLaunch = false;
        startAndFinish();
    }
}

@Override
protected void onPause() {
    activityPaused = true;
}

@Override
public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    outState.putBoolean(PENDING_LAUNCH_KEY, pendingLaunch);
    super.onSaveInstanceState(outState, outPersistentState);
}

private class  LogoLauncher extends Thread{
    public void run(){
        try{
            sleep(3000 * SLEEP_TIMER);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        if (activityPaused) pendingLaunch = true;
        else startAndFinish();
    }
}

private void startAndFinish() {
    Intent intent = new Intent(loadScreen.this, createdby.class);
    startActivity(intent);
    finish();
}