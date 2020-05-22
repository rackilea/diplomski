public class HashtableDemo {

    static Hashtable<Integer, Customer> customerHashtable;

    public static void main(String[] args) {

        customerHashtable = new Hashtable<Integer, Customer>();
        customerHashtable.put (1, new Customer("david", "+13035003433", new Address("AR", "77555")));

        Customer customer = new Customer("mark", "13035003433", new Address("AR", "77200"));
        addNewCustomers(2, customer);
    }

    public static void addNewCustomers(int key, Customer customer) { 
        customerHashtable.put(key, customer);
        System.out.println(customerHashtable.get(key).toString());
    }
}