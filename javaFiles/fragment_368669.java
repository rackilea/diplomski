List<String> users = pUsers.collect();
for(String u : users){
    if(u.equals("error"))
        continue;
    else{
        String cql = "MERGE (n:User {value:'" + u +"'})";
        st.executeUpdate(cql);
    }
}