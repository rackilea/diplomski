//BookDetailsService class
@Inject
BookService bookService;

public void createBookDetails(BookDetails details) {
    Book b = new Book();
    b.setId(details.getId());
    b.setName("Bible");

    bookService.createBook(b);

    details.setBook(b);//b still managed

    super.persist(details);
}