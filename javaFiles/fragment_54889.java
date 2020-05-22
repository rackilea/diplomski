public class TextViewClick implements OnClickListener
{
  public String textHolder;

  public TextViewClick(Context c)
  {
    TextSpeaker tts1 = new TextSpeaker(c);
  }

  @Override
  public void onClick(View v) 
  {
    TextView tv=(TextView) v;
    tv.setTextColor(R.color.red);
    textHolder = (String) tv.getText();
    System.out.println(textHolder);
    tts1.tts.speak(textHolder, TextToSpeech.QUEUE_FLUSH, null);
  }
}