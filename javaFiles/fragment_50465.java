while (i.hasNext()) {
    String element = i.next();
    if (list2.contains(element)) {
        i.remove();
    }
}