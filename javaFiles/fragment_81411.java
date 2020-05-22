public void paintComponent(Graphics g) 
{
    super.paintComponent(g);
    g.drawImage(image, 0, 0, null);
    this.getViewScrollPane().revalidate();
}

public Dimension getPreferredSize() 
{
    if(image != null)
        return new Dimension(image.getWidth(),image.getHeight());
    else
        return super.getPreferredSize();
}