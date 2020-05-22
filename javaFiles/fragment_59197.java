ListIterator<Book> iter = books.listIterator();
while(iter.hasNext()){
    if(iter.next().getIsbn().equals(isbn)){
        iter.remove();
    }
}