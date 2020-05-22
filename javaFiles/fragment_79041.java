LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
// Start recognition process pruning previously cached data.
recognizer.startRecognition(true);
SpeechResult result = recognizer.getResult();
// Pause recognition process. It can be resumed then with startRecognition(false).
recognizer.stopRecognition();