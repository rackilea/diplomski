class ReadXMLFile {

    String processed, state;

    public void parseXml() {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            StringReader sr = new StringReader("<SCAN_LIST_OUTPUT>     <RESPONSE>         <DATETIME>2017-06-12T07:28:46Z</DATETIME>         <SCAN_LIST>             <SCAN>                 <ID>3332486</ID>                 <REF>compliance/1347341337.35943</REF>                 <TYPE>Scheduled</TYPE>                 <TITLE><![CDATA[MY PC Scan]]></TITLE>                 <USER_LOGIN>USER</USER_LOGIN>                 <LAUNCH_DATETIME>2017-06-13T07:30:09Z</LAUNCH_DATETIME>                 <DURATION>00:06:29</DURATION>                 <PROCESSED>1</PROCESSED>                 <STATUS>                     <STATE>Finished</STATE>                 </STATUS>                 <TARGET><![CDATA[10.10.25.50]]></TARGET>             </SCAN>         </SCAN_LIST>     </RESPONSE> </SCAN_LIST_OUTPUT>");
            //Reader sr = new InputStreamReader(new ByteArrayInputStream(data.getBytes()), "UTF-8");
            InputSource is = new InputSource(sr);
            saxParser.parse(is, new SampleHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String argv[]) {

        ReadXMLFile obj = new ReadXMLFile();
        obj.parseXml();
        System.out.println(obj.processed);
        System.out.println(obj.state);

    }

    private class SampleHandler extends DefaultHandler {

        boolean bprocessed = false;
        boolean bstate = false;


        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {

            if (qName.equalsIgnoreCase("PROCESSED")) {
                bprocessed = true;
            }

            if (qName.equalsIgnoreCase("STATE")) {
                bstate = true;
            }
        }

        public void endElement(String uri, String localName,
                String qName) throws SAXException {
        }

        public void characters(char ch[], int start, int length) throws SAXException {

            if (bprocessed) {
                processed = new String(ch, start, length);
                bprocessed = false;
            }

            if (bstate) {
                state = new String(ch, start, length);
                bstate = false;
            }
        }
    }
}