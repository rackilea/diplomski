//note the context parameter, pass this one when you create your ViewAngleActivity instance
public ViewAngleActivity(Context context){
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        Log.d("gettingViewAngle:","in onCreateSensor got Created");
        //then you use your context to reg.
        mSensorManager.registerListener(context, accelerometer, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(context, magnetometer, SensorManager.SENSOR_DELAY_UI);
    }