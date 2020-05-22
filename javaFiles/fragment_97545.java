public class BookRepository implements Repository {

    public List<Book> getAll(BookFetchingStrategy fetchingStrategy) {
        switch(fetchingStrategy) {
            case BOOK_WITH_NAMES_AND_DESCRIPTIONS:
                List<Book> bookList = session.createQuery("from Book").list();

                // Notice empty statement in order to start each subselect
                for (Book book : bookList) {
                    for (Name address: book.getNameList());
                    for (Description description: book.getDescriptionList());
                }

            return bookList;
        }
    }

    public static enum BookFetchingStrategy {
        BOOK_WITH_NAMES_AND_DESCRIPTIONS;
    }

}