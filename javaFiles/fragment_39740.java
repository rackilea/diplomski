public void updateGraphics()
{
     BufferStrategy bs = getBufferStrategy();
     Graphics g = bs.getDrawGraphics();
     paint(g);
     g.dispose();
     bs.show();
     Toolkit.getDefaultToolkit().sync();
     update(g);
}