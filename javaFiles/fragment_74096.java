/**
 * Processes events occurring on this component. By default this
 * method calls the appropriate process<event type>Event
 * method for the given class of event.
 * ...
 */
protected void processEvent(AWTEvent e) {
    if (e instanceof FocusEvent) {
        processFocusEvent((FocusEvent)e);
    } else if (e instanceof MouseEvent) {
        switch(e.getID()) {
          case MouseEvent.MOUSE_PRESSED:
          case MouseEvent.MOUSE_RELEASED:
          case MouseEvent.MOUSE_CLICKED:
          case MouseEvent.MOUSE_ENTERED:
          case MouseEvent.MOUSE_EXITED:
              processMouseEvent((MouseEvent)e);
              break;
          case ...:
              ...
        }
    } else if (e instanceof KeyEvent) {
        processKeyEvent((KeyEvent)e);
    } else if (e instanceof ComponentEvent) {
        processComponentEvent((ComponentEvent)e);
    } else if (...) {
        ...
    } ...
}