activity.runOnUiThread(new Runnable() {
          @Override
          public void run() {
            cameraSource.stop();
            cameraRunning = false;
          }
        });