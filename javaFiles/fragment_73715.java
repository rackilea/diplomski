public static void startListening( Context accelerometerListener ) 
{

    aContext = accelerometerLister;
    sensorManager = (SensorManager) aContext.
            getSystemService(Context.SENSOR_SERVICE);

    .......
    .........

        listener = (AccelerometerListener) accelerometerListener;
    }
}