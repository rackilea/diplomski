private float last_x, last_y, last_z;
  @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long curTime = System.currentTimeMillis();
            // only allow one update every 100ms.

            //  if ((curTime - lastUpdate) > 150) {


                x = 0;
                y = 0;
                z = 0;
                x = sensorEvent.values[0];
                y = sensorEvent.values[1];
                z = sensorEvent.values[2];

                float speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;

                    last_x = x;
                    last_y = y;
                    last_z = z;
                }
            }