import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

jsonStringList = jsonStringList.substring(2, jsonStringList.length()-2); //removed brackets and double quotes 
    jsonStringList = jsonStringList.replaceAll("\\\\", ""); //remove extra backslashes
    System.out.println("jsonStringList "+jsonStringList); //valid json //[{"Name":"name.pdf","ValueDate":"2016-08-30T22:00:00+0000"}]
    try {
        JSONArray jsonArray = new JSONArray(jsonStringList);
        for (int i=0;i<jsonArray.length();i++) {

              JSONObject jsonObj = jsonArray.getJSONObject(i);
              String name = jsonObj.getString("Name");
              String valueDate = jsonObj.getString("ValueDate");
              System.out.println("Name : "+name + "ValueDate : "+valueDate);
  }