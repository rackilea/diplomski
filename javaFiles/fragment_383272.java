public class AndroidPlatform implements Platform {

    private Activity activity;
    private MotionSensor motionSensor;
    private Handler handler;

    public AndroidPlatform(Activity activity) {
        this.activity = activity;
        this.motionSensor = new MotionSensor(activity);
        this.handler = new Handler();
    }

    @Override
    public void startMotionSensors(final PlatformCallback<float[]> callback) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                motionSensor.start(callback);
            }
        });
    }

    @Override
    public void stopMotionSensors() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                motionSensor.stop();
            }
        });
    }
}