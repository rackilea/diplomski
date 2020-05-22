public static String addCommentXML(String xmlString, String tagName, String comment)
{
    String[] parts = xmlString.split("\\Q<" + tagName + ">\\E");
    String output = parts[0];
    for (int i = 1 ; i < parts.length ; i++) {
        output += comment + "<" + tagName + ">" + parts[i];
    }
    return output;
}