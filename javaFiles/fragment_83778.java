public abstract class Component implements ImageObserver, MenuContainer,
                                       Serializable
{
...
    protected void processMouseEvent(MouseEvent e) {
        MouseListener listener = mouseListener;
        if (listener != null) {
            int id = e.getID();
            switch(id) {
              case MouseEvent.MOUSE_PRESSED:
                  listener.mousePressed(e); // invoking a specific listener's method
                  break;
              case MouseEvent.MOUSE_RELEASED:
                  listener.mouseReleased(e);
                  break;
              ...


}