@Override
public void onInit(int status) {
    // TODO Auto-generated method stub

    if (status != TextToSpeech.ERROR) {
        tts.setLanguage(Locale.UK);
        speakText(String.valueOf(pick_speekDgt));

    }
   }
}