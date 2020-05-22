public void gatherSpeech(String prompt)
{
    Intent recognizeIntent = getRecognizeIntent(prompt);
    try
    {
        startActivityForResult(recognizeIntent, SpeechGatherer.VOICE_RECOGNITION_REQUEST_CODE);
    }
    catch (ActivityNotFoundException actNotFound)
    {
        Log.w(D_LOG, "did not find the speech activity, not doing it");
    }
}