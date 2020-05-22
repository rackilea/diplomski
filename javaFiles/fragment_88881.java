private List<String> bookTitles;

@Override
public void init() {
    // You might access the servlet config here.
    bookTitles = new ArrayList<>();
    Collections.addAll(bookTitles,
        "Faith in Fakes: Travels in Hyperreality",
        "Null-A",
        "Wasp");
}

@Override
... doGet(...) ... {
    log("book_titles are passed: " + bookTitles);
    ...
}