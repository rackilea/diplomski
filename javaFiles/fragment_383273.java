public class MotionSensor implements SensorEventListener {

    private Activity activity;
    private SensorManager sensorManager;

    private float[] gravity = new float[3];
    private float[] geomag = new float[3];

    private float[] rotationMatrix = new float[16];
    private float[] inclinationMatrix = new float[16];

    private PlatformCallback<float[]> callback;

    public MotionSensor(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        switch (event.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
                gravity = event.values.clone();
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                geomag = event.values.clone();
                break;
        }

        if (gravity != null && geomag != null) {
            boolean success = SensorManager.getRotationMatrix(rotationMatrix,
                    inclinationMatrix, gravity, geomag);

            if (success) {
                notifyCallback(new Result(), rotationMatrix);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    private void notifyCallback(Result result, float[] rotationMatrix) {
        callback.callback(result, rotationMatrix);
    }

    public void start(PlatformCallback<float[]> callback) {
        this.callback = callback;

        sensorManager = (SensorManager) activity.getSystemService(Activity.SENSOR_SERVICE);
        if (sensorManager != null) {
            boolean accelerometerSupport = sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                    SensorManager.SENSOR_DELAY_UI);
            boolean magneticFieldSupport = sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                    SensorManager.SENSOR_DELAY_UI);

            if (!accelerometerSupport || !magneticFieldSupport) {
                sensorManager.unregisterListener(this);
                notifyCallback(new Result(Result.STATE.FAILED, "Not supported"), null);
            }
        } else {
            notifyCallback(new Result(Result.STATE.FAILED, "Not supported"), null);
        }
    }

    public void stop() {
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }
}