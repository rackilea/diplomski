sensorManager = (SensorManager)   
getActivity().getSystemService(Context.SENSOR_SERVICE);
sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
sensorMagnetic = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
sensorEventListener = new SensorEventListener() {
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            magnetic = event.values;
            tv.setText("X: "+ magnetic.values[0] + ...);
        }
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            gravity = event.values;
            tv2.setText(X: " + gravity.values[0] + ...);
        }
    }
}