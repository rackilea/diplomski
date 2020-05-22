public void constructorOrMethodThatCreatesViewport()
{
    // ...
    this.viewport.addMouseListener(mainMouseListener);
    this.viewport.addMouseMotionListener(mainMouseListener);
}

private MouseListener currentViewportMouseListener;
private MouseMotionListener currentViewportMouseMotionListener;
private MouseListener currentScrollableMouseListener;
private MouseMotionListener currentScrollableMouseMotionListener;
private final MyMouseListener mainMouseListener = new MyMouseListener();

private class MyMouseListener implements MouseListener, MouseMotionListener
{
    private MouseEvent viewportToScrollableEvent(MouseEvent event)
    {
        Rectangle viewRect = viewport.getViewRect();
        MouseEvent r = new MouseEvent((Component) event.getSource(), 
                event.getID(), event.getWhen(), event.getModifiers(), 
                event.getX()+viewRect.x, event.getY()+viewRect.y, 
                Math.abs(event.getX()+viewRect.x), 
                Math.abs(event.getY()+viewRect.y), 
                event.getClickCount(), event.isPopupTrigger(), 
                event.getButton());
        return r;
    }

    public void mouseClicked(MouseEvent e)
    {
        if (null != currentScrollableMouseListener)
        {
            currentScrollableMouseListener.mouseClicked(viewportToScrollableEvent(e));
        }
        if (null != currentViewportMouseListener)
        {
            currentViewportMouseListener.mouseClicked(e);
        }
    }

    public void mousePressed(MouseEvent e)
    {
        if (null != currentScrollableMouseListener)
        {
            currentScrollableMouseListener.mousePressed(viewportToScrollableEvent(e));
        }
        if (null != currentViewportMouseListener)
        {
            currentViewportMouseListener.mousePressed(e);
        }
    }

    public void mouseReleased(MouseEvent e)
    {
        if (null != currentScrollableMouseListener)
        {
            currentScrollableMouseListener.mouseReleased(viewportToScrollableEvent(e));
        }
        if (null != currentViewportMouseListener)
        {
            currentViewportMouseListener.mouseReleased(e);
        }
    }

    public void mouseEntered(MouseEvent e)
    {
        if (null != currentScrollableMouseListener)
        {
            currentScrollableMouseListener.mouseEntered(viewportToScrollableEvent(e));
        }
        if (null != currentViewportMouseListener)
        {
            currentViewportMouseListener.mouseEntered(e);
        }
    }

    public void mouseExited(MouseEvent e)
    {
        if (null != currentScrollableMouseListener)
        {
            currentScrollableMouseListener.mouseExited(viewportToScrollableEvent(e));
        }
        if (null != currentViewportMouseListener)
        {
            currentViewportMouseListener.mouseExited(e);
        }
    }

    public void mouseDragged(MouseEvent e)
    {
        if (null != currentScrollableMouseMotionListener)
        {
            currentScrollableMouseMotionListener.mouseDragged(viewportToScrollableEvent(e));
        }
        if (null != currentViewportMouseMotionListener)
        {
            currentViewportMouseMotionListener.mouseDragged(e);
        }
    }

    public void mouseMoved(MouseEvent e)
    {
        if (null != currentScrollableMouseMotionListener)
        {
            currentScrollableMouseMotionListener.mouseMoved(viewportToScrollableEvent(e));
        }
        if (null != currentViewportMouseMotionListener)
        {
            currentViewportMouseMotionListener.mouseMoved(e);
        }
    }

}