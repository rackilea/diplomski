EditText editText = (EditText) findViewById(R.id.ediText);
ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
toggle.setOnCheckedChangeListener(new     CompoundButton.OnCheckedChangeListener() {
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            editText.setEnabled(false);
        } else {
            editText.setEnabled(true);
        }
    }
});

Timer timer = new Timer();
TimerTask task = new TimerTask(){

    public void run() {
            toggle.setChecked(false); //setting button off after time interval ends.
    }
}

timer.schedule(task, 1000); // time is for 1 sec after that TimerTask run method will be called.