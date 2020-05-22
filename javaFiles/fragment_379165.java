private int getSqrtCount(Double value) {

    final Double sqrt = Math.sqrt(value);

    if((sqrt > 2) && (sqrt % 1 == 0)) {
        return getSqrtCount(sqrt) + 1;
    }
    return 0;
}