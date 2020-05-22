while(myTestNeedsToRun) {
    if(speedChangeReceived) {
        sendSpeedChange();
        speedChangeReceived = false;
    }
}

private void createSpeedDelegate() {
   EspressoMachineValues.setOnSpeedChangeListener(new EspressoMachineValues.OnSpeedChangeListener() {
    @Override
    public void onSpeedChanged(double speed) {
        //assert speed is correct.
        assertTrue(getStaticSpeed() == speed);
        speedChangedReceived = true;
    }
});