for (int r = 0; r < 4; r++) {
        for (int c = 0; c < 4; c++) {
            if ((c + r) % 2 != 0) {
                g.setColor(Color.black);
            } else {
                g.setColor(Color.white);
            }
            g.fillRect(r * (600 / 3), (c * (600 / 3)), 200, 200);
        }
    }