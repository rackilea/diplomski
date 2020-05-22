String xlsSchema = "<?xml-stylesheet type=\"text/xsl\" href=\"" + template.getAbsolutePath() + "\"?>";
String newTag = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
String tag = "<?xml";
String strippedXML = "";

// Remove all XML tags from beginning
if (integrationResponse.toLowerCase().contains(tag)) {
    strippedXML = integrationResponse.replaceAll("<\\?[^>]*\\?>", "");
    result = newTag + xlsSchema + strippedXML;
}
else 
    result = newTag + xlsSchema + integrationResponse;