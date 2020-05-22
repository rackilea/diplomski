Toolkit.getDefaultToolkit ().addAWTEventListener ( new AWTEventListener ()
{
    public void eventDispatched ( AWTEvent event )
    {
        // All application key events will be passed here
    }
}, AWTEvent.KEY_EVENT_MASK );