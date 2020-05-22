int mainTime=0,snoozeTime=0; 

public void openCD(View v) {

    class MyListener implements NumberPicker.OnValueChangeListener {

        @Override
        public void onValueChange(NumberPicker numberPickerMain, int oldVal, int newVal) {
            mainTime = newVal;
        }
    }

    class MyListener2 implements NumberPicker.OnValueChangeListener {

        @Override
        public void onValueChange(NumberPicker numberPickerSnooze, int oldVal, int newVal) {
            snoozeTime = newVal;
        }
    }

    String confirmation = "Your shower is set for " + mainTime + " minutes with a " 
            + snoozeTime + " minute snooze. Enjoy your shower!";
    Toast.makeText(this.getApplicationContext(), confirmation, Toast.LENGTH_LONG).show();
    Intent countdown=new Intent(this, CountDown.class);
    startActivity(countdown);
}