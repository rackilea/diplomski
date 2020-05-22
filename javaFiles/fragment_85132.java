public class WikiParser {
    public static class Cm {
        public String mPageId;
        public String mNs;
        public String mTitle;
    }
    private static class CmListener implements StartElementListener {
        final List<Cm> mCms;
        CmListener(List<Cm> cms) {
            mCms = cms;
        }
        @Override
        public void start(Attributes attributes) {
            Cm cm = new Cm();
            cm.mPageId = attributes.getValue("", "pageid");
            cm.mNs = attributes.getValue("", "ns");
            cm.mTitle = attributes.getValue("", "title");
            mCms.add(cm);
        }
    }
    public void parseInto(URL url, List<Cm> cms) throws IOException, SAXException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try {
            parseInto(new BufferedInputStream(con.getInputStream()), cms);
        } finally {
            con.disconnect();
        }
    }
    public void parseInto(InputStream docStream, List<Cm> cms) throws IOException, SAXException {
        RootElement api = new RootElement("api");
        Element query = api.requireChild("query");
        Element categoryMembers = query.requireChild("categorymembers");
        Element cm = categoryMembers.requireChild("cm");
        cm.setStartElementListener(new CmListener(cms));
        Xml.parse(docStream, Encoding.UTF_8, api.getContentHandler());
    }
}