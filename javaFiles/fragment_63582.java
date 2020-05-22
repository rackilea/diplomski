public static JSONArray get_inactive_bookings(String username) {
    JSONArray array = new JSONArray();
    //JSONObject obj = new JSONObject(); -> this line must be in while loop
    Connection conn = null;
    ResultSet rs = null;
    int index = 0;
    int user_id = Users.get_user_id(username);
    String sql = "select * from bookings where user_id =" + user_id + 
            " and Effettiva_Restituzione is not null";
    try {
        conn = Utilities.connect();
        Statement st = conn.createStatement();
        rs = st.executeQuery(sql);
        //This is where I think problem shows up
        while (rs.next()) {
            JSONObject obj = new JSONObject(); // moved to here
            obj.put("Booking_ID", rs.getInt("booking_id"));
            obj.put("Book_Title", Books.get_title(rs.getInt("book_id")));
            obj.put("Booking_Date", rs.getString("Data_Prenotazione"));
            obj.put("Return_Date", rs.getString("Data_Restituzione"));
            array.add(index, obj);
            index++;
        }
    } catch (SQLException ecc) {
        System.out.println("ERROR: " + ecc.getMessage());
    } finally {
        Utilities.disconnect(conn);
    }
    return array;
}