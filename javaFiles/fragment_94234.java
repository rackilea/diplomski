int recursive(int p1, String p2, long p3) {
    if (baseCase) {
        return 0;
    }
    ...
    int level = 0;
    if (someCondition) {
        level = 1+recursive(nextP1, nextP2, nextP3);
    }
    return level;
}