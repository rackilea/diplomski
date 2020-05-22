public class Store {

    private ArrayList<Customer> custArr;

    public new Store() {
        custArr = new ArrayList<Customer>();
    }

    public void addSale(String customerName, double amount) {
        custArr.add(new Customer(customerName, amount));
    }

    public Customer getSaleAtIndex(int index) {
        return custArr.get(index);
    }

    //or if you want the entire ArrayList:
    public ArrayList getCustArr() {
        return custArr;
    }
}