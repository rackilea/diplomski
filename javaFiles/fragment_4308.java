BookShelf bookshelf = new BookShelf();
    bookshelf.setShelfnumber( "001" );
    bookshelf.setShelfowner( "John Doe" );

    File f = new File( "data.txt" );
    Scanner scanner = new Scanner( f );
    Book book = null;
    Magazine magazine = null;
    int chapters = 0;
    int pages = 0;
    while( scanner.hasNext() ){
        int cellid = scanner.nextInt();
        switch(cellid){
        case 0:
            book = new Book();
            bookshelf.getBookOrMagazine().add( book );
            book.setAuthor( scanner.nextLine() );
            chapters = 0;
            break;
        case 1:
            Chapter chapter = new Chapter();
            book.getChapter().add( chapter );
            chapter.setNumber( scanner.nextInt() );
            book.setChapters( ++chapters );
            break;
        case 2:
            magazine = new Magazine();
            bookshelf.getBookOrMagazine().add( magazine );
            magazine.setAuthor( scanner.nextLine() );
            pages = 0;
            break;
        case 3:
            Page page = new Page();
            magazine.getPage().add( page );
            page.setNumber( scanner.nextInt() );
            magazine.setPages( ++pages );
            break;
        }
    }