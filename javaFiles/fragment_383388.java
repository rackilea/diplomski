#{javascript:
    importPackage(com.ibm.commons.util.io.json);
    var jsonText = doc.getItemValueString(itemname);
    var jsonFactory:JsonFactory = JsonJavaFactory.instanceEx;
    var jsonObject = JsonParser.fromJson(jsonFactory, jsonText);
    sessionScope.put('configJSON', jsonObject);
}