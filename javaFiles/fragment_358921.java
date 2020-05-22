onCreate(){
  textToSpeech = new TextToSpeech(getApplicationContext(), new 
  TextToSpeech.OnInitListener() {
    @Override
    public void onInit(int status) {
        if (status != TextToSpeech.ERROR) {
            textToSpeech.setLanguage(Locale.UK);
        }
    }
  });

  textToSpeech.speak("Hello World", TextToSpeech.QUEUE_FLUSH, null, null);
  checkIfTTSIsSpeaking();
}

checkIfTTSIsSpeaking() {
    new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
      if(textToSpeech.isSpeaking()){
         performAction();
      }else{
         checkIfTTSIsSpeaking();
      }
     }
    },10);
}


performAction(){…}