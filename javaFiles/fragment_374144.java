Display display = ... your display

Listener keyListener = new KeyListener();

display.addFilter(SWT.KeyDown, keyListener);


class KeyListener implements Listener
{
  @Override
  public void handleEvent(final Event event)
  {
    if (event.stateMask == SWT.COMMAND && event.keyCode == 'w')
     {
       ... close the window
     }
  }
}