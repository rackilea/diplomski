for (int x = 0; x < trLine.getRegionWidth(); x++) {
    for (int y = 0; y < trLine.getRegionHeight(); y++) {
        int colorInt = pixmap.getPixel(trLine.getRegionX() + x, trLine.getRegionY() + y);
        emptyPixmap.drawPixel(x , y , colorInt );
    }
}