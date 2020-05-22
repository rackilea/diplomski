String bookname ="abc";
        String ISBN="qwerty123";
        String AuthorName="user3213";
        String Category="New";
        String Quantity="1";
        String BookShelfNo="5";
        int Row=1;
        int Column=5;

        String Query = "insert into book_details(Book_Name, ISBN, Author, Category, Quantity, BookShelfNo,`Row`,`Column`) VALUES('" +bookname + "','" + ISBN + "','" + AuthorName + "','" + Category + "','" + Quantity + "','" + BookShelfNo +"', " + Row + ", " + Column + ")";
        stmt.execute(Query);