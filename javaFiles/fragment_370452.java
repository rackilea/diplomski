public class CashRegister {
    public static void register() {
        System.out.print("Please enter cash register's float: $");
        registerfloat = in.nextLine();
        balance = Double.parseDouble(registerfloat);
        //... rest of code
    }
}