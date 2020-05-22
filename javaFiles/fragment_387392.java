Element best = list.get(0);
for (int i = 1; i < list.size(); i++) {
    Element cur = list.get(i);
    if (cur.isA() || (cur.isB() && best.isC())) {
        best = cur;
    }
}
// best will have property A if possible, then property B if possible, then C.