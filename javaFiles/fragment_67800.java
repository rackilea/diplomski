// Get which part, and book the user would like to edits
System.out.print("Enter Book ID to begin editing: ");
int bookID = sc.nextInt();
sc.nextLine();

List<Book> filtered = newBook.stream().filter((Book t) -> t.getId() == bookID).collect(Collectors.toList());
if (!filtered.isEmpty()) {
    Book bookToEdit = filtered.get(0);