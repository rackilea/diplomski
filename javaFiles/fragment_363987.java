@Override 
protected void onDestroy() { 
if (runnableObject != null) 
myHandler.removeCallbacks(runnableObject ); 
super.onDestroy(); 
}
private void backPressed() {
if (mpAudioSdCard != null) {
            mpAudioSdCard.stop();
            mpAudioSdCard.release();
            mpAudioSdCard = null;
        }

}