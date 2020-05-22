if(menu == 1) {
    book.addBook(isbn, title, year, author, price);
    System.out.print("Enter ISBN: ");
    isbn = scan.nextInt();
    System.out.print("Enter Title: ");
    title = scan.next();
    System.out.print("Enter Year: ");
    year = scan.nextInt();
    System.out.print("Enter Author: ");
    author = scan.next();
    System.out.print("Enter Price: ");
    price = scan.nextDouble();
}