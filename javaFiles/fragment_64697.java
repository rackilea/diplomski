public static Pixmap getPixmapRoundedRectangle(int width, int height, int radius, int color) {

 pixmap = new Pixmap(width, height, Format.RGBA8888);
 pixmap.setColor(color);


// pink rectangle

 pixmap.fillRectangle(0     ,radius, pixmap.getWidth()           , pixmap.getHeight()-2*radius);

// green rectangle

 pixmap.fillRectangle(radius,0     , pixmap.getWidth() - 2*radius, pixmap.getHeight()         );


// Bottom-left circle

 pixmap.fillCircle(radius, radius                                     , radius);

// Top-left circle

pixmap.fillCircle(radius                   , pixmap.getHeight()-radius, radius);

// Bottom-right circle

 pixmap.fillCircle(pixmap.getWidth()-radius, radius                   , radius);

// Top-right circle

 pixmap.fillCircle(pixmap.getWidth()-radius, pixmap.getHeight()-radius, radius);

 return pixmap;
}