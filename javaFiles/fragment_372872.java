@Override
public void paintControl(PaintEvent event) {
  Canvas canvasProgress = (Canvas)event.widget;
  Rectangle clientArea = canvasProgress.getClientArea(); // Client area

  .. set colors

  gc.fillRectangle(clientArea.x, clientArea.y, clientArea.x + clientArea.width - 1, clientArea.y + clientArea.height - 1);
  gc.drawRectangle(clientArea.x, clientArea.y, clientArea.x + clientArea.width - 1, clientArea.y + clientArea.height - 1);
}