try {
    XmlPullParser parser = Xml.newPullParser();
    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
    parser.setInput(inputStream, null);
    parser.nextTag();
    return readFeed(parser);
}catch(IllegalArgumentException e){ //Replace this with the more specific exception
  //do something
}catch(Excpetion e){ //You can have multiple catch blocks from specific to general
  //do something
}finally {
    inputStream.close();

}