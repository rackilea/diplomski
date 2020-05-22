@GET
@Path("/get")
@Produces(MediaType.APPLICATION_XML)
public ResposeList addObjects() {

    Book book = new Book(); 
    book.setName("Here is the Game");
    book.setAuthor("HHH");

    BookStore bookstore = new BookStore();
    bookstore.setName("Prateek Bookstore");
    bookstore.setLocation("Vasanth Nagar");

    ArrayList<Object> list = new ArrayList<Object>();
    list.add(book);
    list.add(bookstore);
    ResposeList books=new ResposeList();
    books.setList(list);

    return books;   
}