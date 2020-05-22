public DeviceOrientation(Context context) {
   mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
   mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

   mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
}