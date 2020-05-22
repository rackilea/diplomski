public class Supplier {
    @Identity
    @GeneratedValue
    private Long id; 
    //stuff
    @OneToMany(mappedBy="supplier")
    private List<Item> items;
    //more stuff
}

public class Item {
    @Identity
    @GeneratedValue
    private Long id; 
    //item stuff
    @ManyToOne
    private Supplier supplier;
    //more item stuff
}