public class compass implements SensorEventListener {
  SensorManager mSensorManager;

  public compass(Context context) {
    mSensorManager = (SensorManager)context.getSystemService(SENSOR_SERVICE);

    // do stuff like register listener
  }
}