Statement st = conn.createStatement();
    try {
        ResultSet rs = st.executeQuery("select col1,col2 from table1");
        // do something
        closeResultSet(rs);
        rs = st.executeQuery("select col1,col2 from table2");
        // do something
        closeResultSet(rs);
    } finally {
        // close Statement
    }