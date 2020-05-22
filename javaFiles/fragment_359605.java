private String getEventsFromAnXML()throws IOException,XmlPullParserException

{
       String attVal = null;
       String desc = null;
        String startTag = null;
       Resources res = this.getResources();
       XmlResourceParser xrp = res.getXml(R.xml.book);
       xrp.next();

     int eventType = xrp.getEventType();
      while (eventType != XmlPullParser.END_DOCUMENT)
       {

         if(eventType == XmlPullParser.START_TAG){

            startTag = xrp.getName();
            if(startTag.equals("Number")){
             attVal =  xrp.getAttributeValue(0); 
            }   
        }
     else if(eventType == XmlPullParser.TEXT){

           if(startTag.equals("Description") && attVal.equals("2"))
             desc =  xrp.getText(); 
        }
        else if(eventType == XmlPullParser.END_TAG)
        {
        }
        eventType = xrp.next();
      }
    return desc;

}