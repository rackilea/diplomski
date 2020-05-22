final Vibrator vibrator = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
final CheckBox vibrateCheckBox = (CheckBox) findViewById(R.id.checkPowerStrong);

final Handler handler = new Handler();

final Runnable r = new Runnable() {
    public void run() {
        vibrator.vibrate(1000);
        handler.postDelayed(this, 1000);
    }
};

vibrateCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

       @Override
       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
           if(vibrateCheckBox.isChecked()) {
               handler.postDelayed(r, 100);
           } else {
               handler.removeCallbacks(r);
               vibrator.cancel();
           }

       }
   }
);