private void populateJPanel(){
        // GET LIST OF ALL BOOKS (selectAll() throws sql exception so we handle it here.)
        List<Book> books = null;
        try {
            books = BookQuery.selectAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
// LOOP THROUGH BOOK LIST
            for (Book book : books) {
                String name = book.getName();
                String author = book.getAuthor();
                String price =  book.getPrice();

                // NOW USE THESE VALUES HOWEVER YOU PLEASE ON YOUR JPANEL
            }
        }