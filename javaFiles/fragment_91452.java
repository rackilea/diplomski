@Override
public void onSensorChanged(SensorEvent Event) {
    float value = Event.values[2];
    if (z.size() <= 3) {
        z.add(value);
    } else {
        z.add(0, value);
        z.remove(z.size() - 1);
    }
}