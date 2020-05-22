public static void SortBooks(Scanner sc, ArrayList<Book> books) {
    Collections.sort(books, new Comparator<Book>() {
        public int compare(Book q1, Book q2) {
            // don't put it in here
            return q1.getBookTitle().compareToIgnoreCase(q2.getBookTitle());
        } 
    });
    // put it here, after the sort
    System.out.println(books);
}