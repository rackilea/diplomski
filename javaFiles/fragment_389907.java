List<String> xxx = new ArrayList<>();
ListIterator<String> iterator = xxx.listIterator();
while (iterator.hasNext()) {
    String s = iterator.next();
    for (String zzz : xyxy) {
        if (!zzz.equals(s)) {
            iterator.add(zzz); //<-- Adding is done through the iterator
        }
    }
}