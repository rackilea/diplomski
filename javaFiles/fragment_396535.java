class MyCanvas extends JPanel
{

public void paintComponent(Graphics g) 
{ 
    g.setColor(new Color(255,255,255));
    g.fillRect(5, 5, getWidth()-5, getHeight()-5);

}

}