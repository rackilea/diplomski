boolean steep = Math.abs(y1 - y0) > Math.abs(x1 - x0);
    if (steep) {
        int t;
        // swap(x0, y0);
        t = x0;
        x0 = y0;
        y0 = t;
        // swap(x1, y1);
        t = x1;
        x1 = y1;
        y1 = t;
    }
    if (x0 > x1) {
        int t;
        // swap(x0, x1);
        t = x0;
        x0 = x1;
        x1 = t;

        // swap(y0, y1);
        t = y0;
        y0 = y1;
        y1 = t;
    }
    int deltax = x1 - x0;
    int deltay = Math.abs(y1 - y0);
    int error = deltax / 2;
    int ystep;
    int y = y0;
    if (y0 < y1)
        ystep = 1;
    else
        ystep = -1;

    for (int x = x0; x < x1; x++) {
        if (steep)
            moveMouse(y, x);
        else
            moveMouse(x, y);
        error = error - deltay;
        if (error < 0) {
            y = y + ystep;
            error = error + deltax;
        }
    }