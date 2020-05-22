public static void main(String[] args)
{
    Display display = Display.getDefault();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Composite content = new Composite(shell, SWT.NONE);
    content.setLayout(new FillLayout());

    Text first = new Text(content, SWT.BORDER);
    Text second = new Text(content, SWT.BORDER);

    content.setTabList(new Control[] {first, second});

    Listener enterListener = new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            /* Is it a traverse via Tab or Enter? */
            if(event.keyCode == SWT.CR || event.keyCode == SWT.TRAVERSE_RETURN || event.keyCode == SWT.TRAVERSE_TAB_NEXT)
            {
                /* Get source of event */
                Widget source = event.widget;

                /* Get traverse order of content composite */
                Control[] tabList = content.getTabList();

                /* Try to find current position in the tab list */
                for(int i = 0; i < tabList.length; i++)
                {
                    if(source.equals(tabList[i]))
                    {
                        /* Get the next item in the tab list */
                        Control nextControl = tabList[(i + 1) % tabList.length];

                        /* And force the focus on this item */
                        nextControl.setFocus();
                        nextControl.forceFocus();

                        return;
                    }
                }
            }
        }
    };

    first.addListener(SWT.KeyUp, enterListener);
    second.addListener(SWT.KeyUp, enterListener);

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}