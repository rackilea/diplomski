public static String getCordinates(String address,String county) throws IOException, ParserConfigurationException, SAXException{
    String thisLine;

    address = address.replace(",", "+");
    address = address.replace(" ", "+");
    county = county.replace(" ", "");

    String fullAddress = address+"+"+county;
    System.out.println(fullAddress);

    URL url = new URL("http://maps.google.com/maps/geo?q="+fullAddress+"&output=xml&key=ABQIAAAANGTAqDyDam_07aWkklK2NBSD41w" +
            "X8VhCBpuiDVjGbFNuXE31lhQB8Gkwy-wmYbmaHIbJtfnlR9I_9A");

    BufferedReader theHTML = new BufferedReader(new InputStreamReader(url.openStream()));

    FileWriter fstream = new FileWriter("url.xml");
    BufferedWriter out = new BufferedWriter(fstream);
    while ((thisLine = theHTML.readLine()) != null)
        out.write(thisLine);
    out.close();

    File file = new File("url.xml");
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(file);
    doc.getDocumentElement().normalize();
    NodeList nl = doc.getElementsByTagName("code");
    Element n = (Element)nl.item(0);
    String st = n.getFirstChild().getNodeValue();

    if (st.equals("200"))
    {
        NodeList n2 = doc.getElementsByTagName("coordinates");
        Element nn = (Element)n2.item(0);
        String st1 = nn.getFirstChild().getNodeValue();


        return st1;
    }
    else
    {
        return null;
    }


}