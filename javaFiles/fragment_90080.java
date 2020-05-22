public class Customer {
     // This field doesn't exist in the database
     // It is simulated with a SQL query
     // "OO speak": Customer owns the orders
     private List<Order> orders;
}

public class Order {
     // This field actually exists in the DB
     // In a purely OO model, we could omit it
     // "DB speak": Order contains a foreign key to customer
     private Customer customer;
}