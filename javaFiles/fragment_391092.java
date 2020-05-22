Graphics2D g2d = (Graphics2D)g;

// Turn anti-aliasing on.
g2d.setRenderingHint(
    RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_ON);

// Draw everything you want...

// Turn anti-aliasing off again.
g2d.setRenderingHint(
    RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_ON);