public class Bag<T> extends HashSet<Set<T>> {

public Bag() {
    super();
}

public List<Set<T>> sorted() {
    return sorted(new SetComparator<T>());
}

public List<Set<T>> sorted(Comparator<Set<T>> comparator) {

    ArrayList<Set<T>> l = new ArrayList<Set<T>>();
    l.addAll(this);
    Collections.sort(l, comparator);
    return l;
}

static class SetComparator<T> implements Comparator<Set<T>> {

    @Override
    public int compare(Set<T> i, Set<T> j) {
        return j.size() - i.size();
    }
}

public static void main(String[] args) {

    Bag<Integer> b = new Bag<Integer>();
    Set<Integer> s1 = new HashSet<Integer>();
    b.add(s1);
    s1.add(10);
    s1.add(11);
    Set<Integer> s2 = new HashSet<Integer>();
    b.add(s2);
    s2.add(20);
    System.out.println(b.sorted());
    s2.add(21);
    s2.add(22);
    System.out.println(b.sorted());
}
}