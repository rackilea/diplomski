class MyThread extends Thread {

private Context context;
public SensorManager sensorManager;

public MyThread(Context context) {
    this.context = context;
}

@Override
public void run()
{
    sensorManager = (SensorManager) context.getSystemService(SENSOR_SERVICE);
    sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
}
/** In Activity **/ 
public static void main(String[] args) {
    new MyThread(getContext()).start();
}