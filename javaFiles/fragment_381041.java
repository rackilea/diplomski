public class BuzzListProvider implements Provider<List<Buzz>> {
    public List<Buzz> get() {
        List<Buzz> buzzes = new ArrayList<Buzz>();
        // Configure them... This might call on a @Inject defined
        // within this BuzzListProvider, on the ctor or a field, or
        // just some code in this method.
        return buzzes;
    }
}