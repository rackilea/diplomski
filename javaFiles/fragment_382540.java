public class Site<E extends Enum<E>> {
    public EnumSet<E> contents;

    public void determineStates(Site<E> a, Site<E> b) {
        this.contents.clear();
        this.contents.addAll(a.contents);
        this.contents.addAll(b.contents);
        a.contents.removeAll(b.contents);
        this.contents.removeAll(a.contents);
    }
}