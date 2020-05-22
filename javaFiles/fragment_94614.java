//render something default transform
AffineTransform defaultTransform = g.getTransform();
AffineTransform newTransform = new AffineTransform(defaultTransform);
newTransform.setScale(xScale, yScale);
g.setTransform(newTransform);
//render something with the new transform
g.setTransform(oldTransform);
//render something with the original transform