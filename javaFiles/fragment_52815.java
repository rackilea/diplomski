try {
    CallableStatement cstmt = con.prepareCall("BEGIN proc_search(?, ?); END;");
    cstmt.setString(1, login);
    cstmt.registerOutParameter(2, OracleTypes.CURSOR); 
    cstmt.execute();
    ResultSet rs = ((OracleCallableStatement)cstmt).getCursor(2);

    while (rs.next()) {
        System.out.println(rs.getString("name"));
    }
} catch (Exception e) {
    System.err.println(e);
    e.printStackTrace();
}