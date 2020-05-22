private static final Map<String, Locale> LOCALES = new LinkedHashMap<String, Locale>() {{
   put("US", Locale.US);
   // many more
}


final Locale locale = LOCALES.get(parent.getItemAtPosition(pos).toString());
if(locale != null)
    textToSpeech = new TextToSpeech(MainActivity.this,
        new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            if (status != TextToSpeech.ERROR) 
               textToSpeech.setLanguage(locale);
        }
    });