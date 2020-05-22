void recursive(int p1, String p2, long p3, int level) {
    ...
    if (someCondition) {
        recursive(nextP1, nextP2, nextP3, level+1);
    }
}