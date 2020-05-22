int eventType = xpp.getEventType();
while (eventType != XmlPullParser.END_DOCUMENT) {
    if(eventType == XmlPullParser.START_DOCUMENT) {
      System.out.println("Start document");
    } else if(eventType == XmlPullParser.START_TAG) {
      System.out.println("Start tag "+xpp.getName());
    } else if(eventType == XmlPullParser.END_TAG) {
      System.out.println("End tag "+xpp.getName());
    } else if(eventType == XmlPullParser.TEXT) {
      System.out.println("Text "+xpp.getText());
    }
    eventType = xpp.next();
}
System.out.println("End document");