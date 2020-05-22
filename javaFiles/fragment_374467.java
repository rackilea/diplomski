List<Book> al = new ArrayList<>();
for (Book book : books) {
    if (authorName.equalsIgnoreCase(book.getAuthor())) {  
        al.add(book);     
    }   
} 
return al;