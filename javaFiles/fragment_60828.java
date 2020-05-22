@Override
public void onSensorChanged(SensorEvent event) {
    mTemperatureValue.setText("Temperature in degree Celsius is " + 
   event.values[0]);

   float pressure = event.values[0];
    mPressureValue.setText("Pressure in mbar is " +
            pressure);
    float altitude = SensorManager.getAltitude
            (SensorManager.PRESSURE_STANDARD_ATMOSPHERE,
                    pressure);
    mAltitudeValue.setText("Current altitude is " +
            altitude);

}