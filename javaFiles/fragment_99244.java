String strDetails = PropertyLoader.get("details");
String strDataKey1= PropertyLoader.get("datakey1");
String strDataKey2 = PropertyLoader.get("datakey2");
String strDetailsOrg = strDetails;

strDetails = strDetails.replace(strDataKey1, "Programmatically Generated Value 1");

strDetailsOrg = strDetailsOrg.replace(strDataKey2, "Programmatically Generated Value 2");