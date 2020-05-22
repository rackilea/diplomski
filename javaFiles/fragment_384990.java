static <E> ObservableList<E> doGenericQuery(long param,
        String sql, Callback<ResultSet,E> factory) {

    Connection con = null;
    ObservableList<E> queryList = FXCollections.<E>observableArrayList();

    try {
        con = MyDataBase.getConnection(); // provide your own connection here
        PreparedStatement ps = con.PreparedStatement(sql);

        ps.setLong(1, param);

        ResultSet jrs = ps.executeQuery();

        while (jrs.next()) {
            queryList.<E>add(factory.<ResultSet,E>call(jrs));
        }

    } catch (SQLException e) {
        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, e);

    } finally {            
        if (jrs != null) try { jrs.close(); } catch (SQLException e) { }
    }

    return queryList; 
}