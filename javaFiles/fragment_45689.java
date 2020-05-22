@Override
     public void receiveDetections(Detector.Detections<Barcode> detections) {
        final SparseArray<Barcode> qrcodes = detections.getDetectedItems();
        if (qrcodes.size() != 0)
        {
          txtResult.post(new Runnable() {
          @Override
          public void run() {
            //Vibration
            Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(600);
            String value=qrcodes.valueAt(0).displayValue;
            txtResult.setText(value.split(" ")[0]);
            inPut.setText(value.split(" ")[1]);
            }
          });
     }