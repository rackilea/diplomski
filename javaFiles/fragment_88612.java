String str = "{aliSerialNumber=111111, pubmsCode=null, orderNumber=111, orderId=null, queryNo=null, msgId=null, consNo=null, userId=null, instId=null, companyId=null, appId=null, extendMap=null, pageSource=null, aliStatus=null}";
str = str.replace("{", "");
str = str.replace("}", "");

String[] temp = str.split(",");
String json = "{";

for (String s : temp)
{
    String key = s.split("=")[0].trim();
    String val = s.split("=")[1].trim();

    json += "\"" + key + "\":";
    json += "\"" + val + "\", ";
}

json = json.substring(0, json.length() - 2);
json += "}";

System.out.println(json);