String getPackageNameFromXml(String s) {
    try {
        XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
        XmlPullParser myParser = xmlFactoryObject.newPullParser();
        myParser.setInput(new StringReader(s));
        int event = myParser.getEventType();
        while (event != XmlPullParser.END_DOCUMENT) {
            String name = myParser.getName();
            switch (event) {
                case XmlPullParser.START_TAG: {
                    if (name.toLowerCase().equals("manifest")) {
                        String packageName = myParser.getAttributeValue(null, "package");
                        if (packageName != null) {
                            return packageName;
                        }
                    }
                }
                break;

                case XmlPullParser.END_TAG: {

                }
                break;
            }
            event = myParser.next();
        }
    } catch (XmlPullParserException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return "";
}