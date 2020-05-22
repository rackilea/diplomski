if (books.isEmpty()) {
    throw new IllegalArgumentException("No books in DB");
}

final int n = books.size() >= 3 ? 3 : books.size();

for (int i = 0; i < n; ++i) {
    if (books.get(i).isAvailable()) {
        listOf3LatestBooks.add(books.get(i));
    }
}