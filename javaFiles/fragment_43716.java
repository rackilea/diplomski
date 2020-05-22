public List<BookItem> getOldestBookPerGenre(List<BookItem> bookItems) {
    Map<String, BookItem> oldestBookByGenre = new HashMap<>();

    for (BookItem bookItem : bookItems) {
        oldestBookByGenre.putIfAbsent(bookItem.getGenre(), bookItem);
        if (Integer.parseInt(bookItem.getYear()) < Integer.parseInt(oldestBookByGenre.get(bookItem.getGenre()).getYear())) {
            oldestBookByGenre.put(bookItem.getGenre(), bookItem);
        }
    }

    return new ArrayList<>(oldestBookByGenre.values());
}