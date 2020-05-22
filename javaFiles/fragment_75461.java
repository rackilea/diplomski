ArrayList<String> statelist = new ArrayList<String>();
            ArrayList<String> stateidlist = new ArrayList<String>();
String sql1 = "SELECT * FROM state WHERE country_ref="+countryref+"                      
PreparedStatement pst1 = db.getConnection().prepareStatement(sql1);
ResultSet j = pst1.executeQuery();
JSONObject obj = new JSONObject();
              pw.println("[");
while (j.next()) {
    state_id = j.getString(1);
    state = j.getString(2);
    country_ref = j.getString(3);
    stateidlist.add(state_id);
                  statelist.add(state);
              }
               obj.put("statelist",statelist);
              obj.put("stateidlist",stateidlist);
pw.println("]");