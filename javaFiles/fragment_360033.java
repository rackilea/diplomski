someLabel:
    for (i = 0; i < 100; i++) {
        for (j = 0; j < 100; j++) {
            if (i % 20 == 0) {
                break someLabel;
            }
        }
    }