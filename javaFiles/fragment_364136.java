public List<Book> filterBooks(List<Book> readingList, int maxPages) {
    return IntStream.range(0, readingList.size())
            .filter(i -> readingList.get(i).getNumPages() <= maxPages)
            .mapToObj(readingList::get)
            .collect(Collectors.toList());
}