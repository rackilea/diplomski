public class CustomerVector {

    Vector<Customer> v = null;

    public CustomVector(){
        v = new Vector<Customer>();
    }

    public void createCustomer(int id, String name, float salary){
        Customer c1Obj = new Customer();
        c1Obj.setCustid(id);
        c1Obj.setCustname(name);
        c1Obj.setCustsalary(salary);

        v.addElement(c1Obj);
    }
    public void custDetails(){

        Enumeration<Customer> custEnum = v.elements();
        while (custEnum.hasMoreElements()) {
            Customer customer = custEnum.nextElement();
            System.out.println(customer);
        }

    }

}