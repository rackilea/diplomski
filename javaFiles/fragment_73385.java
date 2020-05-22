public class DatabaseConnection {

    static final String URL = "jdbc:mysql://localhost:3306/rubyrail?useSSL=false";
    static final String Username = "root";
    static final String Password = "root";

    private static Connection createConnection() {
        return DriverManager.getConnection(URL, Username, Password);
    }

    public static void create() {
        try (Connection connection = createConnection()) {
            // do something with the connection
        } catch (SQLException e) {
            e.printStackTrace();
            // or something else to handle the error
        }
    }

    // same for the rest of your methods

    public static void main (String args[]) {
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
                create();
                break;
            // other cases
            }
        }
    }
}