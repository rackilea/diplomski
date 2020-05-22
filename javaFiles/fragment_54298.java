public void listBooks(int isbn, String title, int year, String author, double price) {
    for(Inventory listBook : list) {

        books.setIsbn(isbn);
        books.setTitle(title);
        books.setYear(year);
        books.setAuthor(author);
        books.setPrice(price);

        System.out.println(books.getIsbn() + "\t"
                + books.getTitle() + "\t"
                + books.getYear() + "\t"
                + books.getAuthor() + "\t"
                + books.getPrice());
        //return listBook;
    }
//return books.getIsbn();
}