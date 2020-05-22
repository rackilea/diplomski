// make sure autocommit is off (postgres)
con.setAutoCommit(false);

Statement stmt = con.createStatement(
                   ResultSet.TYPE_SCROLL_INSENSITIVE, //or ResultSet.TYPE_FORWARD_ONLY
                   ResultSet.CONCUR_READ_ONLY);
ResultSet srs = stmt.executeQuery("select * from ...");