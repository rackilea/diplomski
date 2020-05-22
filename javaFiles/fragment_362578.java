public long median() {
    if (nElems % 2 == 0) {
        int index1 = nElems/2-1;
        return (a[index1]+a[index1+1]) / 2;
    }
    return a[nElems/2];
}