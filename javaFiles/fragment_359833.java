class Bucket implements Comparable<Bucket> {
    Element filling;

    @Override
    public int compareTo(Bucket o) {
        return Float.compare(filling.getVolume(), o.filling.getVolume());
    }
}