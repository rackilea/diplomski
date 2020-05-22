public static void main(String[] args) {

    ReservationSystem resSystem = new ReservationSystem();
    //Getting the values for a new reservation from user
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter First Name: ");
    String firstName = sc.nextLine();
    System.out.println("Enter Last Name: ");
    String lastName = sc.nextLine();
    System.out.println("Enter Price: ");
    float price = sc.nextFloat();
    System.out.println("Enter Seat Number: ");
    int seatNumber = sc.nextInt();
    System.out.println("Enter Seat Letter: ");
    char seatLetter = sc.next().charAt(0);
    sc.close();
    // Adding new reservation object to the list
    resSystem.addReservation(new Reservation(firstName, lastName, price, seatNumber, seatLetter));

    // Printing All the reservations from the list
    resSystem.viewAllReservations();
}