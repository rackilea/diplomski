public class TreeSetMy<E> extends TreeSet<E> {

    public ArrayList<E> getFirstN(int n) {
        if (n > this.size()) {
            n = this.size();
        }

        ArrayList<E> firstN = new ArrayList<>(n);
        Iterator iter = this.iterator();

        for (int i = 0; i < n; i++) {
            firstN.add((E) iter.next());
        }

        return firstN;
    }
}