public void trimStringsInPlace(List<String> listToTrim) {
    ListIterator<String> it = listToTrim.listIterator();
    while (it.hasNext()) {
      it.set(it.next().trim());
    }
}