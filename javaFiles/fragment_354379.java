public class Test {

    public static void main (String[] args){
        Test t = new Test();
    }

    public Test() {
        Customer customer = new FastFoodCustomer();
        test(Customer.class); 
        test(customer.getClass());
    }


    public <T> void test(Class<T> clazz) {
        System.out.println(clazz);
    }

}

class Customer{

}

class FastFoodCustomer extends Customer{

}