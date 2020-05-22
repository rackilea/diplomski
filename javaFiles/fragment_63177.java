JSONObject final = new JSONObject();
    JSONArray ja = new JSONArray();
try {
    Statement ac = DBL.getConnection().createStatement();
    ResultSet r5 = ac.executeQuery("Select * from msg");
   while(r5.next()){
        System.out.println("Value taken from database"+r5.getString("content"));
        JSONObject jo = new JSONObject();
        jo.put("Description", r5.getString("content"));
        jo.put("Id", r5.getString("id"));
        jo.put("Issent",r5.getString("issent"));
        ja.put(jo);
}

   ret= final.put("List", ja).toString();