if (x == 2) break;

for (int i = 0; i < list.size() - 1; i++) {
    if (x > list.get(i)) {
        list.add(i, x);
        break;
    }
}