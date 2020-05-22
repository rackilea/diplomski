public String showAllBooks() {
    StringBuilder msg = new StringBuilder();

    for(Book book : books) {
       // separator char between books
       if (msg.size() > 0){
         msg.append("-");    
       } 
       msg.append(book.getTitle() + book.getStatus());
    }     
    return msg.toString();       
}