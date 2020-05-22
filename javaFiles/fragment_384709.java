public class StepCounterManager implements SensorEventListener{

boolean timerStarted = false;
private float initCount, finalCount, currentCount;

public Activity activity;
private boolean activityRunning;
private boolean hasRecorded;
private SensorManager sensorManager;
private int storedSteps;

public StepCounterManager(Activity activity){
    this.activity = activity;
    this.hasRecorded = false;
    this.storedSteps = 0;
}

public void stepCounterInit(){
    sensorManager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
    timer();
    timerStarted = true;
}

//timer starts at the start of app and restarts every 10 minutes
public void timer(){
    Timer t = new Timer(false);
    Toast.makeText(this.activity, "timer started", Toast.LENGTH_SHORT).show();
    t.schedule(new TimerTask() {
        @Override
        public void run() {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    getFinalStepCount();
                }
            });
        }
    },  600000);
}

public void register(){
    activityRunning = true;
    Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    if(countSensor != null){
        sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
    } else {
        Toast.makeText(this.activity, "Count sensor not available", Toast.LENGTH_SHORT).show();
    }
}

public void unRegister(){
    activityRunning = false;
}

@Override
public void onSensorChanged(SensorEvent event) {
   if(hasRecorded == false){
   hasRecorded = true;
   BlockRecording();
    if(activityRunning){
        int TempCurrent = event.values[0] - storedSteps;
        currentCount = currentCount + (event.values[0] - TempCurrent);
        System.out.println(currentCount);
    }
    if(timerStarted){
        resetInitialStepCount();
    }
   storedSteps = event.values[0];
}else{
}
}


public void BlockRecording(){
Timer t = new Timer(false);
    t.schedule(new TimerTask() {
        @Override
        public void run() {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    hasRecorded = false;
                }
            });
        }
    },  250);
}

@Override
public void onAccuracyChanged(Sensor sensor, int accuracy) {

}

//a new initial count has to be made because the step count can only reset after a reboot
public void resetInitialStepCount(){
    initCount = currentCount;
    Toast.makeText(this.activity, "initial count is: " + initCount, Toast.LENGTH_SHORT).show();
    timerStarted = false;
}

public void getFinalStepCount(){
    finalCount = currentCount-initCount;
    Toast.makeText(this.activity, "final count is: " + finalCount, Toast.LENGTH_SHORT).show();
    resetInitialStepCount();
    timer();
    //todo: send finalcount to database
}
}