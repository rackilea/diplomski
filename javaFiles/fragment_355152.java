public class YourActivity extends Activity {
    private double G = 9.81;
    private double CRASH_G_MULTIPLIER = 2;
    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startDropListening();
    }
    private void startRecording(){
        // your code that does the recording here
    }
    private void startDropListening(){
        SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sm.registerListener(
            new SensorEventListener(){
                @Override public void onAccuracyChanged(Sensor arg0, int arg1) {}
                @Override public void onSensorChanged(SensorEvent arg0) {
                    double accel = Math.sqrt(
                            Math.pow(arg0.values[0], 2) +   
                            Math.pow(arg0.values[1], 2) + 
                            Math.pow(arg0.values[2], 2));
                    if (accel > G * CRASH_G_MULTIPLIER){
                        startRecording();
                    }
                }
            }, 
            sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
            SensorManager.SENSOR_DELAY_NORMAL);
    }
}