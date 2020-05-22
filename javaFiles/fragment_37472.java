ResultSet res = st.executeQuery(s);
int id = 0;
if(res.next()){
   id = res.getInt("BatchID");
}
request.setAttribute("BatchID", id);