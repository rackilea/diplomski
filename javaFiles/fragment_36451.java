CharSequence[] bookTitles = new CharSequence[books.size()];
int index = 0;
for (Book book : books) {
    bookTitles[index++] = book.title;
}
return bookTitles;