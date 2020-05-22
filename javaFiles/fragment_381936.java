YourActivity.this.runOnUiThread(new Runnable(){
@Override
public void run(){
    try {
             initRecorder(mCameraView.getHolder().getSurface());
             mMediaRecorder.start();
    } catch (IOException e) {
         e.printStackTrace();
    }
}
);