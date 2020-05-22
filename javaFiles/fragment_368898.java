public class BogusSub extends BogusSuper {
    public BogusSuper(Collection<String>... a) {
        super(a); // typed to Collection<String>...
    }
    public BogusSuper(String... a) {
        super(a); // typed to String...
    }
}