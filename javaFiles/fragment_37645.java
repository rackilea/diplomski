public class Customer {

    public enum CustomerType {
        INDIVIDUAL, BUSINESS;
    }
    private CustomerType type;
    private int years;
    private int discount;

    public Customer(CustomerType individual, int years) {
        this.type = individual;
        this.years = years;
    }
}