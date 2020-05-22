Iterator<Integer> i = orig.iterator();
while (i.hasNext()) {
    if (i.next() >= mid) {
        i.remove();
    }
}