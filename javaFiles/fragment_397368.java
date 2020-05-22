String xml = "<row>\n"
    + "        <link href=\"B&#252;ro.txt\" target=\"_blank\">\n"
    + "            my link\n" + "        </link>\n" + "    </row>";

InputStream is = new ByteArrayInputStream(xml.getBytes());
Document doc = DocumentBuilderFactory.newInstance()
    .newDocumentBuilder().parse(is);

XMLSerializer xs = new XMLSerializer();
xs.setOutputCharStream(new PrintWriter(System.err));

xs.serialize(doc);