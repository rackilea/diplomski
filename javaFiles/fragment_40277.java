class Book {
    String ISBN;

    Book(String ISBN) {
        this.ISBN = ISBN;
    }
}

class KidsBook extends Book {
    String kidsVariable;
    KidsBook(String ISBN, String kidsVariable) {
        super(ISBN);
        this.kidsVariable = kidsVariable;
    }
}