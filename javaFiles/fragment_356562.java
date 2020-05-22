public static class MyGrid extends JComponent
{
    private int step = 10;

    public MyGrid ()
    {
        super ();
    }

    public Dimension getPreferredSize ()
    {
        return new Dimension ( 500, 500 );
    }

    protected void paintComponent ( Graphics g )
    {
        super.paintComponent ( g );
        drawGrid ( g );
    }

    public void drawGrid ( Graphics g )
    {
        int width = getWidth ();
        int height = getHeight ();
        Color bright = new Color ( 255, 255, 255, 200 );
        Color transparent = new Color ( 255, 255, 255, 100 );

        for ( int ix = step; ix < width; ix += step )
        {
            if ( ( ix / step ) % 10 == 0 )
            {
                g.setColor ( bright );
            }
            else
            {
                g.setColor ( transparent );
            }
            g.drawLine ( ix, 0, ix, height );
        }

        for ( int iy = step; iy < height; iy += step )
        {
            if ( ( iy / step ) % 10 == 0 )
            {
                g.setColor ( bright );
            }
            else
            {
                g.setColor ( transparent );
            }
            g.drawLine ( 0, iy, width, iy );
        }
    }
}