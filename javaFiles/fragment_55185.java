public class MyControl extends Composite
{
    private final Listener focusListener;

    public MyControl(final Composite parent, final int style)
    {
        /* initialize the control... */

        focusListener = new Listener()
        {
            public void handleEvent(Event event)
            {
                if (!(event.widget instanceof Control))
                {
                    return;
                }

                boolean isOurChild = false;
                for (Control c = (Control) event.widget; c != null; c = c.getParent())
                {
                    if (c == container)
                    {
                        isOurChild = true;
                        break;
                    }
                }

                if (isOurChild)
                {
                    System.out.println("Our child is " + (event.type == SWT.FocusIn ? "focused" : "unfocused"));
                }
            }
        };

        getDisplay().addFilter(SWT.FocusIn, focusListener);
        getDisplay().addFilter(SWT.FocusOut, focusListener);

        addDisposeListener(new DisposeListener()
        {
            public void widgetDisposed(DisposeEvent e)
            {
                getDisplay().removeFilter(SWT.FocusIn, focusListener);
                getDisplay().removeFilter(SWT.FocusOut, focusListener);
            }
        });
    }
}