long currentTime = System.currentTimeMillis();
 if(currentTime - lastTick >= DELAY) {
   // Calculate a new position for the line
   pos += (int) (((double) DELAY / DURATION) * getWidth());
   lastTick = currentTime;
 }