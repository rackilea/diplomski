scrollPane.addEventFilter(ScrollEvent.SCROLL, event -> {
   if(event.isControlDown())
   {
      zoomCanvas(event) // zoom the canvas instead of scrolling the actual pane.
      event.consume();
   }
});