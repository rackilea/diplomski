public void study()
{
    if( book == null ){
          library.borrowBook(card);
          return book;
    }            
    else{
        if( !book.isFinished() ){
          book.readNextChapter();
        }
        else{
          library.returnBook(book);
        }
    }

}