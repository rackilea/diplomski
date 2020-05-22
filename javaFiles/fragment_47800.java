public class BookList implements Iterable<Book> {
    private final List<Book> bList = new ArrayList<Book>();

    @Override
    public Iterator<Book> iterator() {
        return bList.iterator();
    }

    ...
}