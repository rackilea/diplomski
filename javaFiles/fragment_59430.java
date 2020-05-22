@Override
public void mouseWheelMoved(MouseWheelEvent e)
{
   int n = e.getWheelRotation();
   if(e.isShiftDown())
       //we've scrolled n times horizontally
   else
       //we've scrolled n times vertically.
}