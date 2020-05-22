Book book1 = new Book();
book1.setBookName("Book title 1");

ArrayList<Book> bookTitle = new ArrayList<Book>();
bookTitle.add (book1);

 for(Book b :bookTitle){
            System.out.println(b.getBookName());
        }