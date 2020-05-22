class DrawingCanvas {
     Image image = createImage(GetWidth(), GetHeight());
     DrawingTool activeTool;

     // this is what gets invoked on every frame
     public void paint(Graphics g){
          g.drawImage(image, 0, 0, null);
     }
}

// when you need to draw something
// (not on every frame, but something new)
activeTool.draw(image.getGraphics());