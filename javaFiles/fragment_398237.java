protected void onActivityResult(int requestCode, int resultCode, Intent data)
{
    Log.d("Speech", "GOT SPEECH RESULT " + resultCode + " req: "
        + requestCode);
    if (requestCode == SpeechGatherer.VOICE_RECOGNITION_REQUEST_CODE)
    {
        if (resultCode == RESULT_OK)
        {
            ArrayList<String> matches = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            Log.d(D_LOG, "matches: ");
            for (String match : matches)
            {
                Log.d(D_LOG, match);
            }
        }
    }
}