@Override
public void onInit(int status) {
    if (status == TextToSpeech.SUCCESS) {
         leftToRead = speakFull(res);

}