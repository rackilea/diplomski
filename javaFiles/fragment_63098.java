Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
        "com.domain.app");

SpeechRecognizer recognizer = SpeechRecognizer
        .createSpeechRecognizer(this.getApplicationContext());
RecognitionListener listener = new RecognitionListener() {
    @Override
    public void onResults(Bundle results) {
        ArrayList<String> voiceResults = results
                .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if (voiceResults == null) {
            System.out.println("No voice results");
        } else {
            System.out.println("Printing matches: ");
            for (String match : voiceResults) {
                System.out.println(match);
            }
        }
    }

    @Override
    public void onReadyForSpeech(Bundle params) {
        System.out.println("Ready for speech");
    }

    /**
     *  ERROR_NETWORK_TIMEOUT = 1;
     *  ERROR_NETWORK = 2;
     *  ERROR_AUDIO = 3;
     *  ERROR_SERVER = 4;
     *  ERROR_CLIENT = 5;
     *  ERROR_SPEECH_TIMEOUT = 6;
     *  ERROR_NO_MATCH = 7;
     *  ERROR_RECOGNIZER_BUSY = 8;
     *  ERROR_INSUFFICIENT_PERMISSIONS = 9;
     *
     * @param error code is defined in SpeechRecognizer
     */
    @Override
    public void onError(int error) {
        System.err.println("Error listening for speech: " + error);
    }

    @Override
    public void onBeginningOfSpeech() {
        System.out.println("Speech starting");
    }

    @Override
    public void onBufferReceived(byte[] buffer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onEndOfSpeech() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onEvent(int eventType, Bundle params) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPartialResults(Bundle partialResults) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onRmsChanged(float rmsdB) {
        // TODO Auto-generated method stub

    }
};
recognizer.setRecognitionListener(listener);
recognizer.startListening(intent);