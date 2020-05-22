try {
    stmt.executeUpdate("INSERT into TEXTVALUEINVERTEDINDEX " + 
         "(FILEID, KEYWORD) "+"values ('"+fileid+"', '"+keyword+"')"); 
} catch (SQLException e) {
    e.printStackTrace();
}