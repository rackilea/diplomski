public static List<Book> selectAll() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        // THE LIST OF BOOKS YOU WILL RETURN
        List<Book> books = new ArrayList<>();
        String sql = "SELECT NAME, AUTHOR, PRICE FROM BOOK";

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "");){

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                String name = rs.getString ("NAME");
                String author = rs.getString ("AUTHOR");
                String price = rs.getString ("PRICE");
                // CREATE NEW BOOK WITH EACH ROW FROM RESULTSET
                Book book = new Book( name, author, price);
                // ADD BOOK TO THE LIST
                books.add(book);
            }
        }
        finally{
            ps.close();
            rs.close();
        }
        // RETURN LIST OF ALL BOOKS
        return books;
    }