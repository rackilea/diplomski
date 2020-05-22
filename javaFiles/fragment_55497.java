private void render() {
   BufferStrategy bs = this.getBufferStrategy();
   if (bs == null)  {
       createBufferStrategy(3);
       return;    
   }        

    for (int i = 0; i<(WIDTH*HEIGHT); i++){ // changed ; for {
        pixels[i] = screen.pixels[i];    
    }

    Graphics g = bs.getDrawGraphics();
    g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
    g.dispose();
    bs.show();

} // added this here