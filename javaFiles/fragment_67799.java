// Get which part, and book the user would like to edits
System.out.print("Enter Book ID to begin editing: ");
int bookID = sc.nextInt();
sc.nextLine();
Book bookToEdit = null;
for (Book book : newBook) {
    if (book.getId() == bookID) {
        bookToEdit = book;
        break;
    }
}
if (bookToEdit != null) {

    System.out.println("Press 1 or 2 to edit.");
    System.out.println("1: Edit title");
    System.out.println("2: Edit author");
    System.out.print("Enter option: ");
    int editOption = sc.nextInt();
    sc.nextLine();

    if (editOption == 1 || editOption == 2) {
        System.out.print("New " + (editOption == 1 ? "title: " : "author: "));
        String value = sc.nextLine();
        switch (editOption) {
            case 1:
                // Update title
                break;
            case 2:
                // Update author
                break;
        }
    } else {
        System.out.println("Invalid edit option");
    }

} else {
    System.out.println("Book with the id of " + bookID + " does not exist");
}