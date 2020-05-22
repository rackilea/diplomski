private class BackgroundTask extends SwingWorker<Void, String> {

    LiveSpeechRecognizer recognizer;

    public BackgroundTask() {
        statusLabel.setText((this.getState()).toString());
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.dmp");
        recognizer = new LiveSpeechRecognizer(configuration);
        recognizer.startRecognition(true);
    }

    @Override
    protected Integer doInBackground() {
        while (!isCancelled()) {
            SpeechResult result = recognizer.getResult();
            List<WordResult> list = result. getWords();
            for (WordResult w : list) {
                // get information to publish, e.g. getPronunciation()
                // publish(getSpelling());
            }
        }
    }

    @Override
    protected void process(java.util.List<String> messages) {
        statusLabel.setText((this.getState()).toString());
        for (String message : messages) {
            textArea.append(message + "\n");
        }
    }

    @Override
    protected void done() {
        recognizer.stopRecognition();
        statusLabel.setText((this.getState()).toString() + " " + status);
        stopButton.setEnabled(false);
        startButton.setEnabled(true);
        bar.setIndeterminate(false);
    }

}