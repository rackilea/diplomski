public int getCount() {
    int cnt = 0;
    for (int i = 0; i < 4; i++) {
        if (shouldShowFragment(i)) cnt++;
    }
    return cnt;
}