int getResult(boolean... vars) {
    int count = 0;
    for (boolean var : vars) {
        count += (var ? 1 : 0);
    }
    return count;
}