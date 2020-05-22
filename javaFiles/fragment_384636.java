Resources res = activity.getResources();
        XmlResourceParser xpp = res
                .getXml(R.xml.myxml);
        xpp.next();
        int eventType = xpp.getEventType();
        eventType = xpp.next();
        eventType = xpp.next();
        eventType = xpp.next();

        short id = Short
                .parseShort(xpp.getText());

        Toast.makeText(
                activity.getApplicationContext(),
                "" + id, Toast.LENGTH_LONG)
                .show();