public class YourActivity extends Activity implements SensorEventListener {
    // there is no WeekSet and WeakHashMap is more handy then List<WeakReference>
    private final  WeakHashMap<HeadingView, Object> sensorObservers = new WeakHashMap<HeadingView, Object>();
    public void addWeekSensorObserver(HeadingView headingView) {
        sensorObservers.put(headingView, null);
    }

    private updateHeadings(float[] deviceHeading) {
        Set<HeadingView> keySet = sensorObservers.keySet();
        for (HeadingView headingView : keySet) {
            headingView.setDeviceHeading(deviceHeading);
        }
    }
}