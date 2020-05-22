for (int j = 0; j < num_columns; j++) {
        x += ((3 / 2) * radius) * 1.5015;
        if (j <= Math.floor(num_columns / 2))
            y = (int) (100 - (j * (height / 2)));
        else
            y = (int) ((100 - (height * (range / 2)) + (num_columns - rows[j]) * (height / 2)));
        for (int i = 0; i < rows[j]; i++) {
            y += height;
            Hex2 hex = new Hex2(i, radius, x, y);  // ****** [A] *****
            hexagons.add(hex.getHex());  // ****** [B] *****
        }
    }