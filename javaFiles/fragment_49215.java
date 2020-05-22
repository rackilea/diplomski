class XmlToObject {

    public static List<List<String>> main() {
        List<List<String>> positions = new ArrayList<>();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse("/path/to/savedPos.xml");
            XPath xp = XPathFactory.newInstance().newXPath();

            NodeList nl = (NodeList) xp.compile("//savedPosition").evaluate(d, XPathConstants.NODESET);
            System.out.println("number of saved positions " + nl.getLength());

            for (int i = 0; i < nl.getLength(); i++) {
                String a = (xp.compile("./nBehaviour").evaluate(nl.item(i)));
                String b = (xp.compile("./aBehaviour").evaluate(nl.item(i)));
                String c = (xp.compile("./gap").evaluate(nl.item(i)));
                String d1 = (xp.compile("./forces").evaluate(nl.item(i)));
                String e = (xp.compile("./findings").evaluate(nl.item(i)));
                String f = (xp.compile("./position1").evaluate(nl.item(i)));
                String g = (xp.compile("./position2").evaluate(nl.item(i)));

                List<String> savedPosition = Arrays.asList(a, b, c, d1, e, f, g);
                positions.add(savedPosition);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return positions;
    }
}