private boolean isReset = true;
private float mMaxValue = 7;
private float mDeadZone = 5;

@Override
public void onSensorChanged(SensorEvent event) {
    float value = event.values[2];

    if(value >= mDeadZone || value <= -mDeadZone) {
        if(isReset && value <= -mMaxValue) {
            Toast.makeText(find_word2.this, "correct", Toast.LENGTH_SHORT).show();
            isReset = false;
        } else if(isReset && value >= mMaxValue) {
            Toast.makeText(find_word2.this, "wrong", Toast.LENGTH_SHORT).show();
            isReset = false;
        }
    } else {
        isReset = true;
    }
}