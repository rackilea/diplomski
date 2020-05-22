try{
  PixmapIO.writePNG(fh, pixmap);
} catch (Exception e) {
  // save it somewhere else
}
pixmap.dispose();