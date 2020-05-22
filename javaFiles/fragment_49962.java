String validXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><feed "
        + "xmlns:oai-identifier=\"http://www.openarchives.org/OAI/2.0/oai-identifier\" "
        + "xmlns:mingo-identifier=\"http://www.google.com\" "
        + "xmlns:abeve-identifier=\"http://www.news.ycombinator.org/OAI/2.0/oai-identifier\">"
        + "</feed>";
String start = "xmlns:oai-identifier=\"";
String end = "\" ";
int location = validXml.indexOf(start);
String result;
if (location > 0) {
    result = validXml.substring(location + start.length(), validXml.length());
    int endIndex = result.indexOf(end);
    if (endIndex > 0) {
        result = result.substring(0, endIndex);
    }
    else {
        throw new Exception("Could not find end!");
    }


}
else {
    throw new Exception("Could not find start!");
}
System.out.println(result);