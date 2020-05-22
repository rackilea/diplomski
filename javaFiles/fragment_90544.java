do {
    System.out.println("1. Add item"); //<-- where are 2-6?
    choice = sc.nextLine().charAt(0);
    switch (choice) {
    case '6': // <-- don't forget case '1' - '5'
        try {
            CarSales.ReadData();
        } catch (IOException e) {
            System.out.println("Error reading file '");
        }
        continue; // <-- here, or a break;
    default:
        System.out.println("Invalid Selection\n");
    }
} while (choice != '6');