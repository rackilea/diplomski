String getData(Element e, String tagName){
    if (e.getElementsByTagName(tagName).getLength() > 0) {
        return e.getElementsByTagName(tagName).item(0).getTextContent(); 
    } else return null;
}


BODY

List<String> elementsList = Arrays.asList("ToolVersion", "ToolName", "SomethingElse");
Element e;
String tagData;

for(String tagName : elementsList){
    tagData = getData(e, tagName);
    //do something here
}