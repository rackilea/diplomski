private static TextToSpeech tts;
    public static TextToSpeech getPrefTTS(Context c) {
        tts = new TextToSpeech(c, ttsInit);
//        tts = new TextToSpeech(c, ttsInit, "specific.tts.package.name.that.you.want.to.use");
    }

    private static TextToSpeech.OnInitListener ttsInit = new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            if (status == TextToSpeech.SUCCESS) {
                int result = tts.setLanguage(new Locale("en", getPrefVoice(c)));
                tts.setPitch(getPrefPitch(c));
                tts.setSpeechRate(getPrefRate(c));

                switch (result) {
                    case TextToSpeech.LANG_AVAILABLE:
                        Toast.makeText(c, "Language Available", Toast.LENGTH_LONG).show();
                        break;
                    case TextToSpeech.LANG_COUNTRY_AVAILABLE:
                        Toast.makeText(c, "Country Available", Toast.LENGTH_LONG).show();
                        break;
                    case TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE:
                        Toast.makeText(c, "Country Variable Available", Toast.LENGTH_LONG).show();
                        break;
                    case TextToSpeech.LANG_MISSING_DATA:
                        Toast.makeText(c, "Missing Data", Toast.LENGTH_LONG).show();
                        break;
                    case TextToSpeech.LANG_NOT_SUPPORTED:
                        Toast.makeText(c, "Language Not Supported", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        }
    };