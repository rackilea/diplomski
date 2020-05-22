List<Book> allBooks = getAllBooks();
List<String> selectedTitles = getSelectedTitles();

Map<String,Book> titleToBook = allBooks.stream()
    .collect(Collectors.toMap(Book::getTitle, Function.identity()));

List<Book> selectedBooks = selectedTitles.stream()
    .map(titleToBook::get).filter(Objects::nonNull)
    .collect(Collectors.toList());