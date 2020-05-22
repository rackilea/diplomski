while(eventType != XmlPullParser.END_DOCUMENT){
    Log.d("LevelCreator", "eventType != XmlPullParser.END_DOCUMENT");

    eventType = parser.next();

    if(eventType != XmlPullParser.START_TAG) {
       continue;
    }
    ...
}