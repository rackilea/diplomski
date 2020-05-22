TextToSpeech tts;  //class field

private void testTextToSpeech() {
        final String toSpeak = getString(R.string.hello_world);
        final int mode = TextToSpeech.QUEUE_FLUSH;
        final HashMap<String, String> hashMap = new HashMap<String, String>();

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR) {

                        tts.setLanguage(Locale.UK);
                        tts.speak(toSpeak, mode, hashMap);
                    }
                }
            }); 
}