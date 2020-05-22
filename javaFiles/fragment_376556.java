while (eventType != XmlPullParser.END_DOCUMENT){
            tagName = xpp.getName();
            if(eventType == XmlPullParser.START_TAG){
                if (tagName != null){
                    if (tagName.equalsIgnoreCase("Command")){
                        Log.d("Command", xpp.getText());
                    }
                    ...
                }
            }
            eventType = xpp.next();
        }