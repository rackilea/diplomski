public interface TestInterface<T> {

    public List<T> getData();

}

public class TestInterfaceImpl implements TestInterface<Customer> {

    public List<Customer> getData() {
        return null; //will return a list of customers
    } 
}