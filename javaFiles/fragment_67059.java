public void onClick(View arg0) {
    ImageButton i = (ImageButton) findViewById(R.id.imageButton1);

    final Parameters p = camera.getParameters();
    if (isFlashOn) {
        i.setImageResource(R.drawable.ic_launcher);
        isFlashOn = false;
        p.setFlashMode(Parameters.FLASH_MODE_OFF);
    } else {
        i.setImageResource(R.drawable.ic_launcher2);
        p.setFlashMode(Parameters.FLASH_MODE_TORCH);
        camera.setParameters(p);
        // Set flag to true
        camera.startPreview();
        isFlashOn = true;
    }