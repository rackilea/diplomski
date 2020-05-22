// Inside GameLoop

private int fps; // Variable you're going to read
private int frameCount; // Keeps track or frames processed
private long lastUpdated;

while(running) {

   if(System.currentTimeMillis() - lastUpdated > 1000) { // 1 second elapsed
      fps = frameCount;
      frameCount = 0;
   }
   frameCount++;
}

public int getFps() {
   return fps;
}