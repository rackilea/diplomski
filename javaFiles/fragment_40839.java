private void readFeed(XmlPullParser parser) throws IOException, XmlPullParserException {
    int eventType = parser.getEventType();
    while (eventType != XmlPullParser.END_DOCUMENT) {
        if (eventType == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name == null) {
                continue;
            }
            if (name.equals("reading")) {
                Log.e(getClass().getSimpleName()," " + parser.getAttributeValue(null, "type"));
                Log.e(getClass().getSimpleName(), " " + parser.getAttributeValue(null, "value"));
            }
        }
        eventType = parser.next();
    }
}