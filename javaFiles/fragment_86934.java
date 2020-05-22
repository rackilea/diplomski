class MickeyOnTheMove extends Thread
{
    private   Boolean          done           = false;
    private   MickeyOnTheMove  mickey         = null;
    private   Point            currentPoint   = null;
    private   GhostDialog      dlgGhost       = null;
    private   Point            prevPoint      = null;
    private   Point            ghostPoint     = null;


    public MickeyOnTheMove(Image ghostImage)
    {
        prevPoint    = new Point(MouseInfo.getPointerInfo().getLocation());
        currentPoint = new Point(MouseInfo.getPointerInfo().getLocation());
        ghostPoint   = new Point((int)currentPoint.getX() + 10,
                                 (int)currentPoint.getY() + 10);

        dlgGhost = new GhostDialog(ghostImage);
        dlgGhost.setLocation(ghostPoint);
        dlgGhost.setVisible(true);
        dlgGhost.setAlwaysOnTop(true);
        dlgGhost.toFront();
    }


    public void run()
    {
        try
        {
            done = false;

            while (!done)
            {
                currentPoint = MouseInfo.getPointerInfo().getLocation();
                if ((prevPoint.getX() != currentPoint.getX()) ||
                        (prevPoint.getY() != currentPoint.getY()))
                {
                    ghostPoint = new Point((int)currentPoint.getX() + 10,
                            (int)currentPoint.getY() + 10);
                    if (null != dlgGhost)
                    {
                        dlgGhost.setLocation(ghostPoint);
                        dlgGhost.setAlwaysOnTop(true);
                        dlgGhost.toFront();
                    }

                    prevPoint = currentPoint;

                    Thread.sleep(0);
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            done = true;
        }
    }


    void setContextCursor(DragSourceContext context, int cursorType)
    {
        context.setCursor(new Cursor(cursorType));
    }


    public void allDone()
    {
        done = true;

        if (null != dlgGhost)
        {
            dlgGhost.setVisible(false);
            dlgGhost.dispose();
            dlgGhost = null;
        }

        if (null != mickey)
        {
            mickey.interrupt();
        }
    }
}