public static boolean insertBook(Book book) throws SQLException{
PreparedStatement insertBook = null;
    try(Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "");){

         insertBook = connect.prepareStatement("INSERT INTO book (NAME, AUTHOR, PRICE) VALUES (?, ?, ?)");


        insertBook.setString(1, book.getName());
        insertBook.setString(2,book.getAuthorName());
        insertBook.setString(3, book.getPrice());
        int i = insertBook.executeUpdate();
        if(i>0){
            JOptionPane.showMessageDialog(null, "Data Is Saved!!");
    return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Data is Not Saved! :( " );
return false;
        }
     catch
            (SQLException ex){
                ex.printStackTrace();
            }
finally{
             insertBook.close();
             }
    }