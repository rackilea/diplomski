public void paint(Graphics g)
{
   g.setXORMode(Color.black);
   // draw old rect if there is one. this will erase it
   // draw new rect, this will draw xored
   g.setDrawMode(); // restore normal draw mode
}