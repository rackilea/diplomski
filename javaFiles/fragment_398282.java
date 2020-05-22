if(rs.next()) {
    // UserInfo is declared within a local context
    UserInfo thisUserInfo = new UserInfo(rs.getString(userName), rs.getString(passWord), rs.getString(lastName), rs.getString(firstName), rs.getString(age), rs.getString(sex), rs.getString(email));
    rs.close();
    stmt.close();
} else {
    // UserInfo is declared within a local context
    UserInfo thisUserInfo = new UserInfo(nullString, nullString, nullString, nullString, nullString, nullChar, nullString);
    rs.close();
    stmt.close();
}
// thisUserInfo does not exist
return thisUserInfo;