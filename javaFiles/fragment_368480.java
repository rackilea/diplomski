protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");

            startBackgroundThread();
            if (textureView.isAvailable()) {
                openCamera();
            } else {
                textureView.setSurfaceTextureListener(textureListener);
            }

            final int PICTURES_LIMIT = 10;

            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                int pictureNo = 0;
                public void run() {                
                    takePicture();
                    pictureNo++;
                    if (pictureNo>PICTURES_LIMIT) {
                       timer.cancel();
                    }

                }


            }, 200, 15000);


    }