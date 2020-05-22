int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                if (xpp.getName().equals(elem)) {
                    eventType = xpp.next(); // advance to inner text
                    return xpp.getText();
                }
            }
            eventType = xpp.next();
        }