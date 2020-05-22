public String addCompanies(String json){
    JSONObject inputJsonObj = new JSONObject(json)

    String input = (String) inputJsonObj.get("company");
    String output = "The input you sent is :" + input;
    JSONObject outputJsonObj = new JSONObject();
    outputJsonObj.put("output", output);

    return outputJsonObj.toString();
}