BufferStrategy bs = Main.frame.getBufferStrategy();
if(bs == null)
    Main.frame.createBufferStrategy(3);

//  if bs was null before, it still is null
Graphics g = bs.getDrawGraphics();