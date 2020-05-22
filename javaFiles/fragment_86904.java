tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {

  public void onDone(String utteranceId) {
      // The text has been read, do your next action

  }

  public void onError(String utteranceId, int errorCode) {
      // Error reading the text with code errorCode, can mean a lot of things

  }

  public void onStart(String utteranceId) {
      // Reading of a sentence has just started. You could for example print it on the screen

  }
});