public class Library extends ArrayList<Book> {
    // Note: no additional data members.
    // The Library is already a List<Book>:

    public Library(Book[] b) {
        super(Arrays.asList(b));
    }

    public int pages() {
        int p = 0;
        for(int i = 0; i < size(); i++) {
            p += get(i).getPages();
        }
        return p;
    }
}