class Book implements Comparable<Book> {
    public String name, id, author, publisher;
    public Book(String name, String id, String author, String publisher) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.publisher = publisher;
    }
    public String toString() {
        return ("(" + name + ", " + id + ", " + author + ", " + publisher + ")");
    }
    @Override
    public int compareTo(Book o) {
        // usually toString should not be used,
        // instead one of the attributes or more in a comparator chain
        return toString().compareTo(o.toString());
    }
}

@Test
public void sortBooks() {
    Book[] books = {
            new Book("foo", "1", "author1", "pub1"),
            new Book("bar", "2", "author2", "pub2")
    };

    // 1. sort using Comparable
    Arrays.sort(books);
    System.out.println(Arrays.asList(books));

    // 2. sort using comparator: sort by id
    Arrays.sort(books, new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.id.compareTo(o2.id);
        }
    });
    System.out.println(Arrays.asList(books));
}