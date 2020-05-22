public class Viewport extends AbsolutePanel {
  private static final String DEFAULT_MOUSE_DOWN_CURSOR = "moveCursor";
  private static final String DEFAULT_MOUSE_DRAG_CURSOR = "pointerCursor";

  private final FocusPanel panel = new FocusPanel();

  private String mouseDownCursor = DEFAULT_MOUSE_DOWN_CURSOR;
  private String mouseDragCursor = DEFAULT_MOUSE_DRAG_CURSOR;

  private Widget view = null;

  private boolean dragging = false;
  private int xOffset, yOffset;

  private boolean eventPreviewAdded = false;

  private static EventPreview preventDefaultMouseEvents = new EventPreview() {
      public boolean onEventPreview(Event event) {
        switch (DOM.eventGetType(event)) {
           case Event.ONMOUSEDOWN:
           case Event.ONMOUSEMOVE:
             DOM.eventPreventDefault(event);
        }
        return true;
      }
    };

  public Viewport() {
    add(panel);

    panel.addMouseListener(new MouseListenerAdapter() {
      public void onMouseEnter() {
       DOM.addEventPreview(preventDefaultMouseEvents);
      }

      public void onMouseLeave() {
       DOM.removeEventPreview(preventDefaultMouseEvents);
      }

      public void onMouseDown(Widget widget, int x, int y) {
        dragging = true;

        xOffset = x;
        yOffset = y;

        DOM.setCapture(panel.getElement());
      }

      public void onMouseMove(Widget widget, int x, int y) {
        if (dragging) {
          removeStyleName(mouseDownCursor);
          addStyleName(mouseDragCursor);

          int newX = x + getWidgetLeft(panel) - xOffset;
          int newY = y + getWidgetTop(panel) - yOffset;

          setWidgetPosition(panel, newX, newY);
        }
      }

      public void onMouseUp(Widget widget, int x, int y) {
        if (dragging) {
          dragging = false;
          removeStyleName(mouseDownCursor);
          removeStyleName(mouseDragCursor);

          DOM.releaseCapture(panel.getElement());
        }
      }
    });
  }

  public String getMouseDownCursor() {
    return mouseDownCursor;
  }

  public void setMouseDownCursor(String mouseDownCursor) {
    this.mouseDownCursor = mouseDownCursor;
  }

  public String getMouseDragCursor() {
    return mouseDragCursor;
  }

  public void setMouseDragCursor(String mouseDragCursor) {
   this.mouseDragCursor  = mouseDragCursor;
  }

 public Widget getView() {
  return view;
 }

 public void setView(Widget view) {
   this.view = view;
   panel.setWidget(view);
 }
}