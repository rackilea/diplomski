final JSONArray ja = new JSONArray();
while (rs.next()) {
   ja.put(new JSONObject()
       .put("Ausgaben", rs.getString("Ausgaben"))
       .put("vom",      rs.getString("vom"))
       .put("Preis",    rs.getString("Preis")));
}
response.getWriter().print(new JSONObject()
    .put("aaData", ja)
    .put("iTotalRecords", zeilen)
    .toString());