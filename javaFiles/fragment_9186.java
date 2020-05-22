AffineTransform oldXForm = g.getTransform();
g.rotate(...);
g.drawLine(...);

g.setTransform(oldXForm); // Restore transform
g.drawLine(...);