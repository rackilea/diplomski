public class CatHandler extends DefaultHandler {
    private StringBuilder chars = new StringBuilder();

    public void startElement(String uri, String lName, String qName, Attributes a)
    {
        final String name = qName == null ? lName : qName;
        if ("cat".equals(name)) {
            chars.setLength(0);
        } else . . .
    }

    public void endElement(String uri, String lName, String qName) {
        final String name = qName == null ? lName : qName;
        if ("cat".equals(name)) {
            String catName = chars.toString();
            // do something with cat name
        } else . . .
    }

    public void characters(char[] ch, int start, int length) {
        chars.append(ch, start, length);
    }