GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice gs = ge.getDefaultScreenDevice(); 
GraphicsConfiguration gc = gs.getDefaultConfiguration();

// Create an image that does not support transparency 

bimage = gc.createCompatibleImage(width, height, Transparency.OPAQUE);

// Create an image that supports transparent pixels 

bimage = gc.createCompatibleImage(width, height, Transparency.BITMASK);

// Create an image that supports arbitrary levels of transparency 

bimage = gc.createCompatibleImage(width, height, Transparency.TRANSLUCENT);