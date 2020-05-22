public Intent getRecognizeIntent(String promptToUse, int maxResultsToReturn)
{
    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
    intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, maxResultsToReturn);
    intent.putExtra(RecognizerIntent.EXTRA_PROMPT, promptToUse);
    return intent;
}