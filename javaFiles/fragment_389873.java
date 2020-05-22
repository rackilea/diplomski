for(int i=0;i< jsonArr.size();i++)
{
    str = jsonArr.get(i).toString();
    jsonObj = (JSONObject)parser.parse(str);
    String sub = jsonObj.get("subid").toString();
    String uname = jsonObj.get("username").toString();
    String regno = jsonObj.get("regno").toString();
    String percent = jsonObj.get("percent").toString();
    model.addRow(new Object[]{sub,uname,regno,percent});            
}