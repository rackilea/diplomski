long eventMask = AWTEvent.MOUSE_MOTION_EVENT_MASK + AWTEvent.MOUSE_EVENT_MASK;
Toolkit.getDefaultToolkit().addAWTEventListener( new AWTEventListener()
{
    public void eventDispatched(AWTEvent e)
    {
        System.out.println(e);
    }
}, eventMask);