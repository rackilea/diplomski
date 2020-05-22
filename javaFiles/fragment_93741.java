@Override protected void onResume() 
  {
    super.onResume();
    sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
  }

  @Override protected void onStop() 
  {
    sm.unregisterListener(this);
    super.onStop();
  }