@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    //This is what you are missing:
    sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_UI);
}
public void onSensorChanged(SensorEvent event)
{
    Sensor sensor = event.sensor;
    if (sensor.getType() == Sensor.TYPE_ACCELEROMETER)
    {
        /// Do something
    }
}
public void onAccuracyChanged(Sensor sensor, int accuracy)
{
}