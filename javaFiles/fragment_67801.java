Map<Integer, Book> newBook = new HashMap<>();
//...
newBook.put(1, new Book(1, "Star Wars", "Somebody"));
newBook.put(2, new Book(2, "Harry Potter", "Somebody else"));
//...

// Get which part, and book the user would like to edits
System.out.print("Enter Book ID to begin editing: ");
int bookID = sc.nextInt();
sc.nextLine();

if (newBook.containsKey(bookID)) {
    Book bookToEdit = newBook.get(bookID);