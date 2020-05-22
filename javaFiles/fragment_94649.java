try (PreparedStatement stmt = con.prepareStatement("insert into test_table"
            + "(ASSESMENT_YEAR,ASSESMENT_MON,CODE,KRA_CODE,BASE_VALUE,ACTUAL_VALUE,"
            + "USERNAME,CHANGE_DATE)"
            + "values (?,?,?,?,?,?,?,SYSDATE)")) {
    stmt.setInt(1, Calendar.getInstance().get(Calendar.YEAR));
    stmt.setInt(2, Calendar.getInstance().get(Calendar.MONTH));
    stmt.setString(3, getcode(dm.getStr1(), dm.getStr2())); 
    stmt.setString(4, dm.getStr4());
    stmt.setInt(5, dm.getNum1());
    stmt.setInt(6, dm.getNum2());
    stmt.setString(7, "admin");

    stmt.executeUpdate();
}