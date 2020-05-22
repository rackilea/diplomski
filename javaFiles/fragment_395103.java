public class Book {

    @Id
    private Long id;
    private String name;

    // ...

    private Set<AuthorRef> authorRefList;

    // ...
}