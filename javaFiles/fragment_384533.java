class Pair implements Comparable<Pair> {
    String name;
    String number;

    //some implementation stuff...

    @Override
    public int compareTo(Pair o) {
        return name.compareTo(o.name);
    }
}