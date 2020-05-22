musicCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (musicCheck.isChecked()) {
            mediaPlayer.start();
        } else {
            mediaPlayer.stop();
        }
    }
});