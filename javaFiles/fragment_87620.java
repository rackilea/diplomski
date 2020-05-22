for (int i = 0; i * i < (maxNum); i++) {
    if (BL.get(i) == true) {
        for (int k = i * 2; k < maxNum; k = k + i) {
            BL.set(i, false);
        }
    }
}