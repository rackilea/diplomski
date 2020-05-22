int maxCopyNumber = -1;
int bookIndex = -1;

ListIterator iter = books.listIterator();
while ( iter.hasNext() ) {
   Book book = iter.next();
   if ( book.getISBNNumber().equals(isbn) && book.getCopyNumber() > maxCopyNumber ) {
       maxCopyNumber = book.getCopyNumber();
       bookIndex = iter.previousIndex();
   }
}
if ( bookIndex >= 0 ) {
   books.remove(bookIndex);
}