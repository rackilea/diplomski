@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = ShoppingCart.class)
class ShoppingCart {

    private int id = -1;

    @JsonIdentityReference
    private Customer customer;
    private LocalDate orderDate;

    // getters, setters, toString
}

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Customer.class)
class Customer {

    private int id = -1;
    private String name;
    private int age;

    // getters, setters, toString
}