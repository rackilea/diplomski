/*while(timeElapsed < 5000000){
              timeElapsed = (System.nanoTime()-timeBefore);
           }*/


           long leftToSleep = 5000000 - timeElapsed;
           if(leftToSleep > 0) {
              //dont forget to surround it with try catch
              Thread.sleep(leftToSleep / 1000000, (int) leftToSleep % 1000000);
           }