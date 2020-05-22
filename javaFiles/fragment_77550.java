import org.apache.commons.lang3.reflect.FieldUtils;

public class Main2 {
    public static void main(String[] args) throws IllegalAccessException {
        Bookstore bookstore = new Bookstore();

        //Just one line to inject the field via reflection
        FieldUtils.writeField(bookstore, "paymentService",new Paypal(), true);
        bookstore.pay(); // Prints: Paying with: Paypal

        //Just one line to inject the field via reflection
        FieldUtils.writeField(bookstore, "paymentService",new Visa(), true);
        bookstore.pay();// Prints Paying with: Visa
    }

    public static class Paypal implements  PaymentService{}

    public static class Visa implements  PaymentService{}

    public static class Bookstore {
        private  PaymentService paymentService;
        public void pay(){
            System.out.println("Paying with: "+ this.paymentService.getClass().getSimpleName());
        }
    }
}