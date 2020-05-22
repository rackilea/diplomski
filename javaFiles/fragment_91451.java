float[] events = new float[4];
int eventIndex;

@Override
public void onSensorChanged(SensorEvent Event) {
   events[ (++eventIndex) % events.length ] = Event.values[2];
}