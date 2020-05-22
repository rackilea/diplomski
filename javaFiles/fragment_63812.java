String language =  "us-US";
Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,language);
intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, language);
intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, language); 
intent.putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE, language);
startActivityForResult(intent, RESULT_SPEECH_GUEST);