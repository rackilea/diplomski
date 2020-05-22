String req = "";
for(String rawName : rawNames)
  req += " food_raw LIKE %"+rawName+"% AND";
if(req.length() > 4)
  req = req.substring(0, req.length()-4); // to remove last " AND"
String query = "SELECT * FROM food_table WHERE "+req;