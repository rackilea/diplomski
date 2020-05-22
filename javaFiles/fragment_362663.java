class ExampleManagedBean {

    @EJB
    CustomerBeanLocal customerBean;

    public String testStuff() {
        int custCount = customerBean.getCustomerCount();
        System.out.println("Number of customers: " + custCount);
        return null;
    }

}