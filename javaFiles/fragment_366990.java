if (x < 0) return;
    if (y < 0) return;
    if (x >= pixels.length) return;
    if (y >= pixels[x].length) return;
    // now it's safe to assign
    oldColor = pixels[x][y];