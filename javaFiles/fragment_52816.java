finally {
    try {
        if (con != null)
            con.close();

        if (cstmt!= null)
            cstmt.close();

        if (rs!= null)
            rs.close();

    } catch (SQLException sqlexc) {
        sqlexc.printStackTrace();
    }
}