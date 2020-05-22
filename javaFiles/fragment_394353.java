Book found = null;
    for (Book book : Book.BookList)
      {
                    if (selection.equals(book.getBookTitle()))
                    {
                       found =  book;
                    }
      }
return found;