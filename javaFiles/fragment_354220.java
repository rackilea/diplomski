public void add(Scanner two){
    System.out.println("Please enter the title: ");
    String title = two.nextLine();
    System.out.println("Enter the ISBN: ");
    int isbn = two.nextInt();
    two.nextLine(); // consume the left over newline token in the buffer
    System.out.println("Enter the publication date: ");
    int month = two.nextInt();int day = two.nextInt();int year = two.nextInt();
    two.nextLine(); // consume the left over newline token in the buffer
    catalog[numBooks++] = new Book(title, isbn, new Date(month, day, year));
}