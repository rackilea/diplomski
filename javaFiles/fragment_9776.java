import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.Mixer.Info;


public class AudioInputButton {
  private int line;
  private AudioFormat format;
  private Info[] lines;
  private TargetDataLine inputLine;
  private DataLine.Info inInfo;
  private int bufferSize;

  public AudioInputButton(int line){
    this.line = line;
    this.setup();
  }

  public AudioInputButton(){
    this.line = 2;
    this.setup();
  }

  private void setup(){
    format = new AudioFormat(8000, 8, 1, true, true); 
    lines = AudioSystem.getMixerInfo();    
    inInfo = new DataLine.Info(TargetDataLine.class, format);
    bufferSize = (int) format.getSampleRate() * format.getFrameSize();
  }

  public void printLineInfo(){
    for (int i = 0; i < lines.length; i++){
      System.out.println(i+": "+lines[i].getName()+"\n"+lines[i].getDescription());
    }
  }

  public void startListening(){
    try{
      inputLine = (TargetDataLine)AudioSystem.getMixer(lines[line]).getLine(inInfo);
      inputLine.open(format, bufferSize);
      inputLine.start(); 

      byte[] buffer = new byte[bufferSize];

      System.out.println("Listening on line " +line+", " + lines[line].getName() + "...");

      while(true){
        inputLine.read(buffer,0,buffer.length);
        int sample = listen(buffer);
        if(sample > 0){
          onClick();
        }
      }
    }catch (LineUnavailableException e){
      System.out.println("Line " + line + " is unavailable.");
      e.printStackTrace();
      System.exit(1);
    }
  }

  public int listen(byte[] eightBitByteArray)
  {
    int index = 0;
    int ret = 0;
    boolean down = false;
    boolean up = false;
    for (int audioByte = 0; audioByte < eightBitByteArray.length;)
    {
      int low = (int) eightBitByteArray[audioByte];
      audioByte++;
      int high = (int) eightBitByteArray[audioByte];
      audioByte++;
      int sample = (high << 8) + (low & 0x00ff);
      if(sample < -1100){
        if(!down){
          onDown();
          ret = sample;
          down = true;
        }
      }else if(sample > 1100){
        if(!up){

          onUp();
          ret = sample;
          down = false;
          up = true;
        }
      }
      index++;
    }
    return ret;
  }

  private void onClick(){
    System.out.println("Click!");
  }

  private void onDown(){
    System.out.println("Down!");
  }

  private void onUp(){
    System.out.println("Up");
  }
}