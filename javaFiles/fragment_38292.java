int from = c.getFrom();
    int to = c.getTo();
    List<DEST> copy = new ArrayList<>(dest.subList(from, to));
    for (int oldIndex = from; oldIndex < to; oldIndex++) {
        int newIndex = c.getPermutation(oldIndex);
        dest.set(newIndex, copy.get(oldIndex - from));
    }