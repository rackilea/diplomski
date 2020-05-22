public abstract class TestOfPassUIThread implements SensorEventListener {

    private SensorManager   sensorManager;
    private Sensor          sensor;
    private HandlerThread   handlerThread;
    private Context         context;
    private Runnable        uiRunnable;

    private float           xAxis;

    public TestOfPassUIThread (Context context) {
        this.context    = context;
        sensorManager   = (SensorManager) context.getSystemService (Context.SENSOR_SERVICE);
        sensor          = sensorManager.getDefaultSensor (Sensor.TYPE_ACCELEROMETER);
    }

    public void register () {
        initUiRunnable ();

        handlerThread   = new HandlerThread ("sensorHandler");
        handlerThread.start ();

        sensorManager.registerListener (
            this,
            sensor,
            SensorManager.SENSOR_DELAY_NORMAL,
            new Handler (handlerThread.getLooper ())
        );
    }

    public void unregister () {
        sensorManager.unregisterListener (this);

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                handlerThread.quitSafely ();
                return;
            }
            handlerThread.quit ();
        } finally {
            uiRunnable = null;
        }
    }

    @Override
    public void onSensorChanged (SensorEvent event) {
        xAxis = event.values [0];

        // your other background operations

        ((Activity)context).runOnUiThread (uiRunnable);

        // your other background operations
    }

    @Override
    public void onAccuracyChanged (Sensor sensor, int accuracy) {

    }

    private void initUiRunnable () {
        uiRunnable = new Runnable () {

            @Override
            public void run () {
                // ...... your other UI operations

                fillTextView (xAxis);

                // ...... your other UI operations
            }
        };
    }

    public abstract void fillTextView (float xAxis);
}