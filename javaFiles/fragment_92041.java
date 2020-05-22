// Create a "copy" of the graphics context so we don't modify any of it's existing
// settings.  This makes it easier to manage the graphics context as we 
// may not want to effect anything else that might be using this graphics context
// into the future
Graphics2D g2d = (Graphics2D)g.create();
RenderingHints hints = new RenderingHints(
    RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
);
g2d.setRenderingHints(hints);
//... continue drawing.
// Dispose of our "copy" of the graphics context
g2d.dispose();