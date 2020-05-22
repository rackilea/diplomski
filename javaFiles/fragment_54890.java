public class TextSpeaker implements OnInitListener
{
  TextToSpeech tts;

  public TextSpeaker(Context c)
  {
    tts = new TextToSpeech(c, this);
  }

  @Override
  public void onInit(int status) {
    if(status != TextToSpeech.ERROR){
        tts.setLanguage(Locale.US);
    }
  }
}