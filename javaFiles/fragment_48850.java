List<Book> books = new ArrayList<Book>();
books.add(aNovel);
books.add(aScienceBook);

int novelCount = 0;

for (Book book : books) {
    if (book instanceof Novel)
        novelCount++;
}