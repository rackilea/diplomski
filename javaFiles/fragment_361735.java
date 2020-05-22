public Album get_album (String title) {
    Connection cn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Album a = null;
    try{
        //creates a connection to the server
        cn = getCon().getConnection();
        //prepare my sql string
        String sql = "SELECT * FROM albums WHERE Title = ?";
        //create prepared statement
        pst = cn.prepareStatement(sql);
        //set sql parameters
        pst.setString(1, title);
        //call the statement and retrieve results
        rs = pst.executeQuery();
        if (rs.next()) {
            a = new Album();
            a.setIdAlbum(rs.getInt("idAlbum"));
            a.setTitle(rs.getString("Title"));
            a.setYear(rs.getInt("Year"));
            a.setIdArtist(rs.getInt("idArtist"));
            a.setIdUser(rs.getInt("idUser"));
            a.setLike(rs.getInt("Like"));
            a.setDislike(rs.getInt("Dislike"));
            a.setNeutral(rs.getInt("Neutral"));
            a.setViews(rs.getInt("Views"));
            //don't return inside try/catch
            //return a;
        }
    } catch (Exception e) {
        String msg = e.getMessage();
        //handle your exceptions
        //e.g. show them in a logger at least
        e.printStacktrace(); //this is not the best way
        //this will do it if you have configured a logger for your app
        //logger.error("Error when retrieving album.", e);
    } finally {
        closeResultSet(rs);
        closeStatement(pst);
        closeConnection(cn);
    }
    return a;
}

public void closeConnection(Connection con) {
    if (con != null) {
        try {
            con.close();
        } catch (SQLException e) {
            //handle the exception...
        }
    }
}

public void closeStatement(Statement st) {
    if (st!= null) {
        try {
            st.close();
        } catch (SQLException e) {
            //handle the exception...
        }
    }
}

public void closeResultSet(ResultSet rs) {
    if (rs!= null) {
        try {
            rs.close();
        } catch (SQLException e) {
            //handle the exception...
        }
    }
}