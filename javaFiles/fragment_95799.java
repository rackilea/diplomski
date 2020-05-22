protected void onResume() {
    super.onResume();
    mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    mStepDetectorSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
    mSensorManager.registerListener(this, mStepDetectorSensor, SensorManager.SENSOR_DELAY_FASTEST);

}