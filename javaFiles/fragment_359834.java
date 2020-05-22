public static void main(String[] args) {
    List<Bucket> elems = new LinkedList<>();
    Bucket o = new Bucket();
    o.filling = new Oil();
    o.filling.setVolume(5);

    Bucket w = new Bucket();
    w.filling = new Water();
    w.filling.setVolume(12);

    elems.add(w);
    elems.add(o);
    Collections.sort(elems);
    for(Bucket b: elems) {
        System.out.println(b.filling.getVolume());
    }
}