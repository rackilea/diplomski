class ScreenListener implements ActionListener, KeyListener 
{
    public void actionPerformed(ActionEvent e)
            {
                System.out.println("ScreenListener: actionPerformed");
                disp = gdev.getFullScreenWindow();
                if(disp == null)
                {
                    return;
                }
                else
                {
                 //draw something
                 ...
                }
            }