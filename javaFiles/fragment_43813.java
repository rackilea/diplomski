public void update(int deltaMs) {
   // Cap at one second.
   if (deltaMs > 1000) {
     delatMs = 1000;
   }

   // Handle movements in small steps to avoid going through walls etc.
   while(deltaMs > 100) {
      updateImpl(100);
      deltaMs -= 100;
   }
   updateImpl(deltaMs);

   render();
 }