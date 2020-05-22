public void mouseExited(MouseEvent e) 
{
    if (e.getSource() instanceof Square)
    {
         ((Square)e.getSource()).exit();
    }
}