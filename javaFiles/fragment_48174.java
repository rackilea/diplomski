if (on) {
        if (freq != 0) {
            sr = new StroboRunner();
            sr.freq = freq;

            if (t != null) {
                t.interrupt(); // this. kill previous thread.
            }

            t = new Thread(sr);
            t.start();
            return;
        } else
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
    }

    if (!on) {
        if (t != null) {
            sr.stopRunning = true;
            t.interrupt(); // this
            t = null;
            return;
        } else
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
    }

    camera.setParameters(params);
    camera.startPreview();
}