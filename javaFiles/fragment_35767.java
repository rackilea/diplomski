public class onlineBookstore {
public static void main(String[] Args) {
    Scanner scanner = new Scanner(System.in);

    String book;
    int noOfBooks;
    System.out.println("Available options are: [book1,book2,book3,book4]");
    System.out.println("Enter the Book type:");
    book = scanner.nextLine();
    System.out.println("Enter the Number of books");
    noOfBooks = scanner.nextInt();

    switch (book) {
    case "book1":
        System.out.println("The total price of the selected book type is : " + noOfBooks * 15.98);
        break;
    case "book2":
        System.out.println("The total price of the selected book type is : " + noOfBooks * 12.50);
        break;
    case "book3":
        System.out.println("The total price of the selected book type is : " + noOfBooks * 11.98);
        break;
    case "book4":
        System.out.println("The total price of the selected book type is : " + noOfBooks * 17.49);
        break;
    default:
        System.out.println("INVALID");
    }
    System.out.println("This is the end of the program");
}