ObjectMapper objectMapper = new ObjectMapper();
PGobject jsonObject = new PGobject();
String Map_Json_String = objectMapper.writeValueAsString(your_map);
jsonObject.setType("jsonb");
jsonObject.setValue(Map_Json_String);

String final insertSql = "INSERT INTO \"Table_Name\""
            + " VALUES (:jsonObject);";