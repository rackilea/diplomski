public List<UserInfo> get_user() {
    List<UserInfo> userInfoList = new AraayList<UserInfo>()
    String sql = "SELECT * FROM USER_INFO";
    try {
        con = new connection.connect().getConnection();
        smt = con.createStatement();
        rset = smt.executeQuery(sql);

        while (rset.next()) {
            UserInfo obj = new UserInfo();
            obj.setEmail(rset.getString(2))
            obj.setPassword(rset.getString(3))

            userInfoList.add(obj);
        }
    } catch (Exception ex) {
        ex.getMessage();
    }

    return userInfoList;
}
// for json object

JSONArray jsonArray = new JSONArray();

public JSONArray get_user() {

    String sql = "SELECT * FROM USER_INFO";
    try {
        con = new connection.connect().getConnection();
        smt = con.createStatement();
        rset = smt.executeQuery(sql);

        while (rset.next()) {
            JSONObject obj = new JSONObject();
            obj.put("Email", rset.getString(2));
            obj.put("Password", rset.getString(3));
            jsonArray.put(obj);
        }
    } catch (Exception ex) {
        ex.getMessage();
    }

    return jsonArray;
}