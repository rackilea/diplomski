int ai = 0;
int bi = 0;
List<Integer> a = Arrays.asList(18,16,11,4,3,2); // this is your first list
List<Integer> b = Arrays.asList(13,8,6); // this is your second list
List<Integer> count = new ArrayList<>();
while (ai < a.size() && bi < b.size()) {
    int current = a.get(ai);
    count.add(current);
    while (bi < b.size() && b.get(bi) > current) {
        ++bi;
    }
    if (bi == b.size()) {
        break;
    }
    current = b.get(bi);
    count.add(current);
    while (ai < a.size() && a.get(ai) > current) {
        ++ai;
    }
    if (ai == a.size()) {
        break;
    }
}