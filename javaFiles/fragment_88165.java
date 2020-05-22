@Override
public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    Engine.game = this;     // <-- add this

    gameView = new GameView(this);
    setContentView(gameView);

    mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
    mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
}