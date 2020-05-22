public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList();
        books.add(new Book("The mistery of cat"));
        books.add(new Book("Category"));
        books.add(new Book("Titanic"));
        books.add(new Book("Adjudicated"));
        getBook(books);
}

public static void getBook(ArrayList<Book> books) {
    for (Book b : books) {
        if (b.getTitle().toLowerCase().contains("cat")) {
            System.out.println(b.getTitle());
        }
    }
}