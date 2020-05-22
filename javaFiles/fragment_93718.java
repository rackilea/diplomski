addMouseListener(new MouseAdapter()
{
    @Override
    public void mouseExited(MouseEvent e)
    {
        Rectangle r = e.getComponent().getBounds();
        Point p = e.getPoint();

        if (p.x < 0 || p.x >= r.width
        ||  p.y < 0 || p.y >= r.height)
            setBackground( Color.RED );
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        setBackground( Color.ORANGE );
    }
});