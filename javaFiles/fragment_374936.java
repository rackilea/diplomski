@Entity
public class Purchase{
@OneToOne
private Customer customer;
}

@Entity
public class Customer{
private String firstName;
private String Lastname;
private String city;
//Below association will only come in picture if customer has real customer data       available when you are collecting the data this way you can clearly identify and separate collected vs real customers
@OneToOne
Customer realCustomer;
}