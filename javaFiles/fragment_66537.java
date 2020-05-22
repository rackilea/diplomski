class Person{
    @OneToMany(mappedBy="person",fetch = FetchType.EAGER)
    private List<Book> books; 
    ...
}

class Book { 
    @ManyToOne
    @JoinColumn(columnDefinition="integer", name = "person", nullable=false)
    @JsonBackReference
    private Person person;
    ...
}