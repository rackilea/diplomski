Boolean longPress = false;

final ToggleButton btnStartStop = (ToggleButton) findViewById(R.id.toggleAction);
btnStartStop.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {
        // TODO Auto-generated method stub
        if (longPress) {
            longPress = false;
        } else {
            longPress = true;
        }
        return true;
    }
});