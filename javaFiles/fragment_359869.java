@OnClick(R.id.main_timer_button)
    public void onButtonClicked() {
        if  (mState == TimerState.STOPPED) {
            mPreferences.setStartedTime(getNow());
            EditText et1 = (EditText)findViewById(R.id.et1);
            String strInput = et1.getText().toString().trim();
            TIMER_LENGHT = Long.parseLong(strInput);
            startTimer();
            mState = TimerState.RUNNING;
        }
    }