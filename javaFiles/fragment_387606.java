public class Item<T extends Comparable<T>>
implements Comparable<Item<T>> {

    ...

    @Override
    public int compareTo(Item<T> o) {
        return getT().compareTo(o.getT());
    }
}