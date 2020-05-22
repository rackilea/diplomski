String s = "select BatchID from CPWorkDetails where BatchId = ?";
st = conn.createStatement();
ResultSet res = st.executeQuery(s);
int Id = res.getInt("BatchID");

try (PreparedStatement st = connection.prepareStatement(s)) {
    st.setString(1, BatchId1[1]);
    ResultSet res = st.executeQuery(s);
    int id = 0;
    if(res.next()){
       id = res.getInt("BatchID");
    }
    request.setAttribute("BatchID", id);
}