@Override
public void onSensorChanged(SensorEvent event) {
    x = event.values[0];

    // The x value in the accelerometer is the 0th index in the array

    // Now you may do what you wish with this x value, and use it to move your ball 
    }
}