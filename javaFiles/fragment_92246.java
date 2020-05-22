for (int i: sortedIdArr) {
    for (Brand b: categories) {
        // assuming no nulls
        if (b.getId() == i) {
            linked.add(b);
            break;
        }
    }
}