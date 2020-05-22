new Thread(new Runnable()
{
    SourceDataLine soundLine;
    public void run()
    {
      soundLine = null;
          int BUFFER_SIZE = 64*1024;  // 64 KB

              // Set up an audio input stream piped from the sound file.
              try {
                 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("title.wav"));
                 AudioFormat audioFormat = audioInputStream.getFormat();
                 DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
                 soundLine = (SourceDataLine) AudioSystem.getLine(info);
                 soundLine.open(audioFormat);
                 soundLine.start();
                 int nBytesRead = 0;
                 byte[] sampledData = new byte[BUFFER_SIZE];
                 while (nBytesRead != -1) 
                 {
                    nBytesRead = audioInputStream.read(sampledData, 0, sampledData.length);
                    if (nBytesRead >= 0) 
                    {
                       // Writes audio data to the mixer via this source data line.
                       soundLine.write(sampledData, 0, nBytesRead);
                    }

                 }
              } catch (Exception ex) 
              {
                 ex.printStackTrace();
              }finally 
              {
                 soundLine.drain();
                 soundLine.close();
              }
        }
}).start();