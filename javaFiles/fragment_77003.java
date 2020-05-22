private final SensorEventListener sensorListener = new SensorEventListener() {
    private float differenceMedian = 0f;

    @Override
    public void onSensorChanged(SensorEvent event) {

        Intent tts = new Intent(context, ttsScreen.class);
        Intent stt = new Intent(context, sttScreen.class);
        Intent cbb = new Intent(context, cbbScreen.class);
        Intent ocr = new Intent(context, ocrScreen.class);

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        acelLast = acelValue;
        acelValue = (float) Math.sqrt((double) (x*x + y*y + z*z));
        float difference = acelValue - acelLast;
        shake = shake * 0.9f + difference; // will increase shake as long as user continues to shake (I think?)

        // differenceMedian will relatively slowly drop towards 0 when difference stays low
        differenceMedian =  (difference + differenceMedian ) /2; 

        if(differenceMedian < 1){ // depends. try to adjust the 1 here
            if(shake > 12 && shake <= 24 ) { // please notice <= because what if shake is exactly 24? same for following else-ifs.
                startActivity(tts);
            }
            else if (shake > 24 && shake <= 36) {
                startActivity(stt);
            }
            else if (shake > 36 && shake <= 48) {
                startActivity(cbb);
            }
            else if (shake > 48) {
                startActivity(ocr);
            }
        }
    }