private static final String baseURI = "https://www.microsoft.com/en-us/download/confirmation.aspx?id=41653";
private static final String downloadURI_Part = "https://download.microsoft.com";
private static final String HREF = "href";

public static void main(String[] args) {
    new DownloadXML().parse();
}

public void parse() {
    try {
        URL url = new URL(baseURI);
        String downloadURL = "";
        org.jsoup.nodes.Document doc1 = Jsoup.connect(url.toString()).get();
        Elements newsHeadlines = doc1.select("a");
        for (org.jsoup.nodes.Element element : newsHeadlines) {
            if (element.hasAttr(HREF) && element.getElementsByAttribute(HREF).attr(HREF)
                    .contains(downloadURI_Part)) {
                downloadURL = element.getElementsByAttribute(HREF).attr(HREF);
                System.out.println(element.getElementsByAttribute(HREF).attr(HREF));
            }
        }
        System.out.println(downloadURL);
        URL url1 = new URL(downloadURL);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(url1.openStream());
        doc.getDocumentElement().normalize();
        NodeList nRegionList = doc.getElementsByTagName("Region");
        System.out.println("----------------------------");

        for (int nRegionCount = 0; nRegionCount < nRegionList.getLength(); nRegionCount++) {
            Node nRegionNode = nRegionList.item(nRegionCount);
            System.out.println("\nCurrent Element :" + nRegionNode.getNodeName());
            if (nRegionNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nRegionNode;
                System.out.println("Region name: " + eElement.getAttribute("Name"));
                NodeList nIPRangeList = eElement.getChildNodes();
                for (int iprangecnt = 0; iprangecnt < nIPRangeList.getLength(); iprangecnt++) {
                    Node nIPRNode = nIPRangeList.item(iprangecnt);
                    if (nIPRNode.hasAttributes()) {
                        // get attributes names and values
                        NamedNodeMap nodeMap = nIPRNode.getAttributes();
                        for (int i = 0; i < nodeMap.getLength(); i++) {
                            Node node = nodeMap.item(i);
                            System.out.println("attr name : " + node.getNodeName());
                            System.out.println("attr value : " + node.getNodeValue());
                        }
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}