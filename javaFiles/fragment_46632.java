public void methodUsingFinals() {
    final ArrayList<book> list = new ArrayList<>();
    final Book currentBook = new Book();

    new Thread(new Runnable() {

        @Override
        public void run() {
            rentBook(list, currentBook);
        }
    });
}

public void methodAcceptingValues(ArrayList<book> list, Book currentBook) {
    new Thread(new Runnable() {

        @Override
        public void run() {
            rentBook(list, currentBook);
        }
    });
}