onCLick() { // <-- start the loop
  count = 0;
  takePicture()
}

onPictureTaken() {
  savePicture(count);
  count++;
  if (count < maxCount) {
      mCamera.startPreview();
      mHandler.postDelayed(runTakePicture(), 1000);
  }
  else {
      releaseCamera();
  }
}

runTakePicture() {
   return new Runnable() {
      public void run() {
        mCamera.takePicture();
      }
   }
}