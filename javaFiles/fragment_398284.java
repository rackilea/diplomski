try {
    stmt = conn.createStatement();
    String getInfoSQL = "SELECT * FROM " + studentsTable + " WHERE USERNAME = '" + userName + "'";
    rs = stmt.executeQuery(getInfoSQL);
    UserInfo thisUserInfo = null;
    if(rs.next()) {
        thisUserInfo = new UserInfo(rs.getString(userName), rs.getString(passWord), rs.getString(lastName), rs.getString(firstName), rs.getString(age), rs.getString(sex), rs.getString(email));
    } else {
        thisUserInfo = new UserInfo(nullString, nullString, nullString, nullString, nullString, nullChar, nullString);
    }
} finally {
    try {
        rs.close();
    } catch (Exception exp) {
    }
    try {
        rs.close();
    } catch (Exception exp) {
        stmt.close();
    }
}
return thisUserInfo;