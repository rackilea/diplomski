import org.apache.commons.lang3.StringUtils;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONArray;

String sInputString =  "return {\"items\":[{\"STANDARDRATEFORMAT\":\"0.00\",\"ASSIGNED_HRS\":0,\"RESOURCE_NAME\":\"#Buddhika \",\"COST\":\"0.00\",\"PERCENTASSIGNED\":\"100.00\",\"EMAIL\":\"Buddhika75@mspblank.com\",\"AVAILABLEFROM\":\"10-May-2011\",\"ALLOCATED_HRS\":\"1872.00\",\"RESOURCE_ID\":36197221,\"AVAILABLETO\":\"31-Mar-2012\",\"calendar\":{\"exceptions\":{},\"weekDayHours\":{}}}]}";

//String sInputString = prev.getResponseDataAsString();

try {
     // Use StringUtils to cut the string between the two
    String sCutString = StringUtils.substringBetween(sInputString, "return {\"items", "]}");
    String sFinalString = "{\"items" + sCutString + "]}";
    log.info("sFinalString=" + sFinalString);

    // Use JSONParser to parse the JSON
    JSONParser parser = new JSONParser(JSONParser.ACCEPT_NON_QUOTE|JSONParser.ACCEPT_SIMPLE_QUOTE); 
    JSONObject rootObject = (JSONObject) parser.parse(sFinalString);
    //JSONObject rootObject = (JSONObject) parser.parse(prev.getResponseDataAsString());

    JSONArray jResourceArray = (JSONArray) rootObject.get("items");

    for (int i=0; i < jResourceArray.size(); i++) {
        log.info(jResourceArray.get(i).toString());
        // You can access individual elements using this
        log.info("RESOURCE_ID=" + jResourceArray.get(i).get("RESOURCE_ID"));
    }


}
catch ( Exception ex) {
    log.info("Exception.." + ex);
}