Class MyGridPane extends JPanel
{

 @Override
    public void paint(Graphics g) {
         super.paint(g); // <----- don't forget to call this

       // then anything you draw will appear above the child component's 
        Graphics2D g2d = (Graphics2D)g.create(); // cloning to work, it is safer aproach
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();// disposing the graphics object 
    }

}