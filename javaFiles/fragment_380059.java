int ix = x2;
                int iy = y2;
                int ih = h2;
                int iw = w2;
                for (k = 1; k < 7; k++) {
                    g.setColor(Color.black);
                    g.drawOval(ix, iy, iw, ih);
                    ix = ix + 5;
                    iy = iy + 5;
                    iw = iw - 10;
                    ih = ih - 10;
                }