XmlPullParser prepareXpp () {
    InputStream istream = getResources().openRawResource(R.raw.data);
    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
    XmlPullParser xpp = factory.newPullParser();
    xpp.setInput(istream, "UTF-8");
    return xpp;
}