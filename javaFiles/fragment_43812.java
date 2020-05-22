public void update(int deltaMs) {
   while(deltaMs > 100) {
      updateImpl(100);
      deltaMs -= 100;
   }
   updateImpl(deltaMs);
   render();
 }