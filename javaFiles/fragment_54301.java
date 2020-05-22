if(menu == 1) {
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

    // this should be at end, after you assign values to variables
    book.addBook(isbn, title, year, author, price);
}