public class WikiParser {
    private static class CmListener implements StartElementListener {
        final List<String> mTitles;
        CmListener(List<String> titles) {
            mTitles = titles;
        }
        @Override
        public void start(Attributes attributes) {
            String title = attributes.getValue("", "title");
            if (!TextUtils.isEmpty(title)) {
                mTitles.add(title);
            }
        }
    }
    public void parseInto(URL url, List<String> titles) throws IOException, SAXException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try {
            parseInto(new BufferedInputStream(con.getInputStream()), titles);
        } finally {
            con.disconnect();
        }
    }
    public void parseInto(InputStream docStream, List<String> titles) throws IOException, SAXException {
        RootElement api = new RootElement("api");
        Element query = api.requireChild("query");
        Element categoryMembers = query.requireChild("categorymembers");
        Element cm = categoryMembers.requireChild("cm");
        cm.setStartElementListener(new CmListener(titles));
        Xml.parse(docStream, Encoding.UTF_8, api.getContentHandler());
    }
}