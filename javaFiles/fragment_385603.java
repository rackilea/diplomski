public static void main(String[] args) throws IOException, SAXException {
        DocumentBuilder builder = JOOX.builder();
        Document xmlExampleDocument = builder.parse(XMLTEST.class.getResourceAsStream("/sample.xml"));
        List<String> doneList = $(xmlExampleDocument).xpath("//*[not(*)]").map(context -> $(context).xpath() + "='" + $(context).text() + "'");
        for (String x : doneList) {
            System.out.println(x);
        }
    }