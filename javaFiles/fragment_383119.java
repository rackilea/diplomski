public List< String > retrieveFromDb( Statement myStmt ){    
    ArrayList<String> list = new ArrayList<>() ;
    String query = "SELECT * FROM product ;" ;

    try (
        ResultSet rs = myStmt.executeQuery( query ) ;
    )
    {
        while( rs.next() ){  // Looping the rows of the result set: first row, second row, third, fourth, and so on.
            String barcode = rs.getString( "barcode" ) ;
            list.add( rs.getString( "barcode" ) );
        }

    } catch (SQLException ex) {
        Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
    }

    return list ;
}