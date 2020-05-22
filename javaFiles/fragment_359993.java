@Override
public void onResume() {
    super.onResume();

    SharedPreferences getprefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    boolean stopshake = getprefs.getBoolean("checkbox", true);
    if (stopshake) {
        mShaker = new ShakeListener(this); 
        mShaker.setOnShakeListener(new ShakeListener.OnShakeListener () {
            public void onShake() { 
                if (!isFlashOn) {
                    Toast.makeText(MainActivity.this, "On" , Toast.LENGTH_SHORT).show();
                    getCamera();
                    turnOnFlash();
                } else {
                    turnOffFlash();
                    Toast.makeText(MainActivity.this, "Off" , Toast.LENGTH_SHORT).show();   
                }
            }
        });
    } else {
        if (mShaker != null) {
            mShaker.setOnShakeListener(null);
            mShaker = null;
        }
    }         
}