int index = 1;
for(Book book : bookList) {
    System.out.println(index + " " + book.getName() + " " + String.valueOf(book.getCopy()) + "copies");
    index++;
}



int borrow = scan.nextInt();
if(borrow==0){
    System.out.println("The book you borrowed is Physics.");

    Book book = (Book) bookList.get(borrow);
    book.setCopy((book.getCopy() - 1));
}