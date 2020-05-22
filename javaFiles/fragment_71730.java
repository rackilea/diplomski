public String deleteItem(int ID_item) {

    String answer = "";
    try {
        Connection con = Connect.getConnection();
        String sql = "Delete FROM item where ID_Item = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, ID_item);

        ps.executeUpdate();

        ps.close();
        con.close();

        answer = "OK";
    } catch (Exception e) {
        answer = e.toString();
    }

    return answer;
}