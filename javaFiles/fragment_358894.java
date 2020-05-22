label.addMouseListener ( new MouseAdapter ()
{
    public void mousePressed ( MouseEvent e )
    {
        lpane.dispatchEvent ( SwingUtilities.convertMouseEvent ( e.getComponent (), e, lpane ) );
    }
} );