Book 
    - >  authors
                -> books  // this field is ignored

Author 
    - >  books
                -> authors // this field is ignored

@ManyToMany
@JsonIgnoreProperties("books")
@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id"))
private Set<Author> authors = new HashSet<>();

@ManyToMany(mappedBy = "authors")
@JsonIgnoreProperties("authors")
private Set<Book> books = new HashSet<>();