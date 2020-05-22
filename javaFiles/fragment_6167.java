mp.setOnCompletionListener(new OnCompletionListener(){
    // @Override
    public void onCompletion(MediaPlayer player) {
    // File has ended, play the next one.
   FunctionPlayFile(audioFileIds[audioindex]);
   audioindex+=1; //increment the index to get the next audiofile
     }
});