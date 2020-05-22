int num = infile.nextInt();
infile.nextLine();
for (int i=0; i<num; i++) {
    String name = infile.nextLine();
    String author = infile.nextLine();
    Double price = infile.nextDouble();
    Book c = new Book (name, author, price);
    books.add(c);
 }