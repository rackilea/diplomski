for (int i = num; i < (wCount - 1); i++) {
    for (int j = (i + 1); j < wCount; j++) {
        wArr[i].setWrd(wArr[j].getWrd());
        wArr[i].setHnt(wArr[j].getHnt());
    }
}