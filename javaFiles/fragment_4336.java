timer = new Timer(20, new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        emptyBI.setRGB(row, column, originalBI.getRGB(row, column);
        label.repaint();

        column++;

        if (column >= originalBI.getWidth()
        {
            row++;
            column = 0;
        }

        if (row >= originalBI.getHeight()
        {
            Timer timer = (Timer)e.getSource();
            timer.stop();
        }
    }
});