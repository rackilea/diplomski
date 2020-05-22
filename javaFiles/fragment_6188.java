public void onSensorChanged(SensorEvent event) {

RealTimeSensor realTimeSensor = new RealTimeSensor();
realTimeSensor.setName(AvailableSensors.getType(event.sensor.getType()).toUpperCase());
realTimeSensor.setValueX(event.values[0]+"");
realTimeSensor.setValueY(event.values[1]+"");
realTimeSensor.setValueZ(event.values[2]+"");

System.out.println(values);

TempStore.sensor.put(AvailableSensors.getType(event.sensor.getType()), realTimeSensor);

Intent intent = new Intent();
intent.setAction("sensor");
context.sendBroadcast(intent);

adaptor.notifyDataSetChanged();}