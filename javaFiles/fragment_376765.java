public void processPCM(ByteData pcm) {
    synchronized (pcmProcessors) {

        int suspensionValue=0;

        Iterator it = pcmProcessors.iterator();
        while (it.hasNext()) {
          //DEFINE THE FLAG FOR SUSPENSION HERE - Logic should be block set ???

           PCMProcessor processor = (PCMProcessor)it.next();
            processor.processPCM(pcm);
        }
    }
  }


    DEFINE A Variable : volatile int flag=Threshold.Value



    Poll this from the main thread which kicks DECODE method 

    Sleep and Resume for whatever time you want