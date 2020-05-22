@Override
protected void paintComponent(Graphics g)
{
    super.paintComponent(g);
    int width = this.getWidth();
    int height = this.getHeight();

    if (balance2 != null && balance2.length > 0) {
        g.setColor(Color.BLACK);
        g.drawLine((int)(width - 0.9 * width), (int)(height - 0.1 * height), (int)(width - 0.1 * width), (int)(height - 0.1 * height)); 

        for (int i = 0; i <  balance2.length; i++)
        {
            g.fillRect(((int)(width - 0.9 * width) + 5 * i), ((int)(height - 0.1 * height) - 5 * i), 5, 5 * i);
        }
    }
}