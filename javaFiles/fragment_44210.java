public class Interface {
    private void run() 
    {

        Scanner console = new Scanner(System.in);
        Store store1 = new Store(); // MUST DO THIS

        int demandRate, option, end;
        double setupCost, unitCost, inventoryCost;
        double sellingPrice, optimalOrder;
        String name;

        do {
            System.out.println("Enter product data (0), Show product data (1), Show product strategy (2), Exit program (9).");
            option = console.nextInt();
            switch(option)
            {
            case 0: enterData();
                    break;
            case 1:
                    break;
            case 2:
                    break;
            case 9: System.out.println("You chose to exit the program.");
                    break;
            default: System.out.println("Please choose a valid option.");
            }
        } while (option != 9);
    }
    private static void enterData()
    {
        int demandRate, option, end;
        double setupCost, unitCost, inventoryCost;
        double sellingPrice, optimalOrder;
        Scanner console = new Scanner(System.in);

        System.out.println("Product name between 3 & 10 characters long: ");
        String name = console.nextLine();
        while ((name.length() < 3) || (name.length() > 10)) {
            System.out.println("Please put in a name between 3 & 10 characters long.");
            name = console.nextLine();
        }           
        name = name.toLowerCase();

        System.out.println("Demand rate: ");
        demandRate = console.nextInt();
        while (demandRate <= 0) {
            System.out.println("Please put in a positive integer.");
            demandRate = console.nextInt();
        }

        System.out.println("Setup cost: ");
        setupCost = console.nextDouble();
        while (setupCost <= 0) {
            System.out.println("Please put in a positive number.");
            setupCost = console.nextInt();
        }

        System.out.println("Unit cost: ");
        unitCost = console.nextDouble();
        while (unitCost <= 0) {
            System.out.println("Please put in a positive number.");
            unitCost = console.nextInt();
        }

        System.out.println("Inventory cost: ");
        inventoryCost = console.nextDouble();
        while (inventoryCost <= 0) {
            System.out.println("Please put in a positive number.");
            inventoryCost = console.nextInt();
        }

        System.out.println("Selling price: ");
        sellingPrice = console.nextDouble();
        while (sellingPrice <= 0) {
            System.out.println("Please put in a positive integer.");
            sellingPrice = console.nextInt();
        }
       }


    public static void main(String[] args) { 
     Interface intFace = new Interface(); 
     intFace.run(); 
     } 

}