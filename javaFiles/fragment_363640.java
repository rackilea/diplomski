PGraphics CreateTile(int w, int h, float scale)
{
    PGraphics pg = createGraphics(w, h, JAVA2D);

    pg.beginDraw();
    for(int x = 0; x<w;x++){
      for(int y = 0; y<h;y++){
        float col = 255*noise(scale * x, scale * y, 30 * scale * frameCount);
        pg.set(x, y, color(col));
      }
    }
    pg.endDraw();

    return pg;
}