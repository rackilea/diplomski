public static void create(Connection connection) {
    try {
        // do something with connection
    } catch (SQLException e) {
        e.printStackTrace();
        // or something else to handle the error
    }
}
public static void main (String args[]) {
    try (Connection connection = createConnection()) {
        int choice= 0;
        while (choice < 6) {
            System.out.println("\n1. Create");
            System.out.println("\n2. Read");
            System.out.println("\n3. Update");
            System.out.println("\n4. Delete");
            System.out.println("\n5. Close");

            choice = scanner.nextInt();
            switch(choice) {
            case 1: 
                create(connection);
                break;
            // other cases
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // or something else to handle the error
    }
}