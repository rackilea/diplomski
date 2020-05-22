public class Menu {

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        boolean orderCompleted = false;
        while(!orderCompleted) {
            printMenu();
            String orderString = a.nextLine();
            int order = Integer.parseInt(orderString);
            int total = 0;
            if(order == 1) {
            } else if(order == 2) {
            } else if(order == 3) {
            } else if(order == 4) {
            } else if(order == 5) {
            }
            System.out.println("Would you like to order more? Press 'y' to continue or 'n' to finish order.");
            orderString = a.nextLine();
            if(orderString.equals("n")){
                orderCompleted = true;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Welcome to Hess Burgers");
        System.out.println("1- Cheeseburger.............$7");
        System.out.println("2- Barbeque Burger..........$8");
        System.out.println("3- Southwestern Burger......$9");
        System.out.println("4- Bacon Cheeseburger.......$10");
        System.out.println("5- Double Stack Burger......$11");
        System.out.println("");
        System.out.print("Please enter your order selection:");
    }
}