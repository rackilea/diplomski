String respJSON = response.toString();

Object obj1 = parser.parse(respJSON);
JSONObject jsonObject = (JSONObject) obj1;

JSONObject some = (JSONObject) jsonObject.getJSONObject("some");

String Nasdasdasd = (String) jsonObject.get("something1");