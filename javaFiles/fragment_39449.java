public void startVoiceRecognitionActivity() {

audio.stop();
Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
    "Kalbėkite");
startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
}