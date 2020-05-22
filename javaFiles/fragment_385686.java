public void study() {
    if(book == null) {
        book = library.borrowBook(card);
    } else {
        if(!book.isFinished()) {
            book.readNextChapter();
        } else {
            library.returnBook(book);
        }
    }
}