public class CustomerFrame extends InternalFrame<Customer> {

    @Override
    protected Collection<? extends Customer> getElements() {
        return array;
    }

    @Override
    protected Serializable getRecord(Customer element) {
       return new Customer(
       element.getName(),
       element.getLastName(),
       element.getAddress1(),
       element.getAddress2(),
       element.getCity(),
       element.getState(),
       element.getZip(),
       element.getPhone(),
       element.getCell());
    }

}