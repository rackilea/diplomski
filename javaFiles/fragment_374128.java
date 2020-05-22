boolean recording = false;

Button button2 = (Button) findViewById(R.id.btnRecord);
button2.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        recording = true;
        Toast.makeText(getBaseContext(), "Data Recording Started" , Toast.LENGTH_SHORT ).show();
    }
});

@Override
public void onSensorChanged(SensorEvent event) {

    Sensor sensor = event.sensor;
    a= event.values[0];
    b=event.values[1];
    c=event.values[2];
    if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {

        magnetismx.setText(Float.toString(event.values[0]));
        magnetismy.setText(Float.toString(event.values[1]));
        magnetismz.setText(Float.toString(event.values[2]));

        if(!recording){
            return;
        }

        try {
            writeToCsv(Float.toString(a), Float.toString(b), Float.toString(c));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}