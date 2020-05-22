Handler handler=new Handler();
 Runnable runnable=new Runnable() {
      @Override
      public void run() {
          mCamera.takePicture(null, null, mPicture);
          handler.postDelayed(this, 15000);
      }
  };