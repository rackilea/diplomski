Display display = Display.getDefault();

display.addFilter(SWT.MouseDown, new Listener()
  {
    @Override
    public void handleEvent(Event event)
     {
       System.out.println("event " + event);

       if (event.widget instanceof Control) {
         Control control = (Control)event.widget;
         System.out.println("display " + control.toDisplay(event.x, event.y));
       }
     }
 });