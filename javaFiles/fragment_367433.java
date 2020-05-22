textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {
            //set language Locale to US
            int result = textToSpeech.setLanguage(loc);
            //check that is language locale available on device or supported
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(guide.this, "Leanguage not present", Toast.LENGTH_SHORT).show();
            } else {
                textToSpeech.setOnUtteranceProgressListener(
                    new UtteranceProgressListener() {
                    @Override
                    public void onStart(String s) {
                        //if ("id".equals(s)
                        Toast.makeText(guide.this, "onStart works", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDone(String s) {
                        //if ("id".equals(s))
                        Toast.makeText(guide.this, "onDone works", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(String s) {
                        //if ("id".equals(s))
                        Toast.makeText(guide.this, "OnError works", Toast.LENGTH_SHORT).show();
                    }
                });                            

                speakOut();
            }
        } else {
            //show toast if initialization failed
            Toast.makeText(getBaseContext(), "TTS Engine Initilization Failed!", Toast.LENGTH_SHORT).show();
        }
    }
});