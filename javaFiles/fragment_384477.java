public static void loopWithoutBlocking() {
     for(int i=0; i<=10; i++) { 
          Logger.info(i);
          await("1s");
     }
     renderText("Loop finished"); }