for (int i = 0; i < 8; i++) {
    if (i % 2 == 0) {
        for (int j = 0; j < 4; j++) {
            p1.add(blackButtons[4 * i + j]);
            p1.add(whiteButtons[4 * i + j]);
        }
    } else {
        for (int j = 0; j < 4; j++) {
            p1.add(whiteButtons[4 * i + j]);
            p1.add(blackButtons[4 * i + j]);
        }
    }
}

add(p1);