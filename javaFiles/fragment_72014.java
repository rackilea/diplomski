Public class CustomRecognizer : Java.Lang.Object, IRecognitionListener, TextToSpeech.IOnInitListener
{
private SpeechRecognizer _speech;
private Intent _speechIntent;


public string Words;


public CustomRecognizer(Context _context)
{
    this._context = _context;
    Words = "";
    _speech = SpeechRecognizer.CreateSpeechRecognizer(this._context);
    _speech.SetRecognitionListener(this);
    _speechIntent = new Intent(RecognizerIntent.ActionRecognizeSpeech);
    _speechIntent.PutExtra(RecognizerIntent.ExtraLanguageModel, RecognizerIntent.LanguageModelFreeForm);
    _speechIntent.PutExtra(RecognizerIntent.ActionRecognizeSpeech, RecognizerIntent.ExtraPreferOffline);
    _speechIntent.PutExtra(RecognizerIntent.ExtraSpeechInputCompleteSilenceLengthMillis, 1000); 
    _speechIntent.PutExtra(RecognizerIntent.ExtraSpeechInputPossiblyCompleteSilenceLengthMillis, 1000);
    _speechIntent.PutExtra(RecognizerIntent.ExtraSpeechInputMinimumLengthMillis, 1500);
}

void startover()
{
    _speech.Destroy();
    _speech = SpeechRecognizer.CreateSpeechRecognizer(this._context);
    _speech.SetRecognitionListener(this);
    _speechIntent = new Intent(RecognizerIntent.ActionRecognizeSpeech);
    _speechIntent.PutExtra(RecognizerIntent.ExtraSpeechInputCompleteSilenceLengthMillis, 1000);
    _speechIntent.PutExtra(RecognizerIntent.ExtraSpeechInputPossiblyCompleteSilenceLengthMillis, 1000);
    _speechIntent.PutExtra(RecognizerIntent.ExtraSpeechInputMinimumLengthMillis, 1500);
StartListening();
}
public void StartListening()
{
    _speech.StartListening(_speechIntent);
}

public void StopListening()
{
    _speech.StopListening();
}

public void OnBeginningOfSpeech()
{

}

public void OnBufferReceived(byte[] buffer)
{
}

public void OnEndOfSpeech()
{

}

public void OnError([GeneratedEnum] SpeechRecognizerError error)
{
    Words = error.ToString();
    startover();
}