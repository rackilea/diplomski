//....
    dataset parsedDataSet;
    try {
        URL url = new URL(
                "http://new.myweather2.com/developer/forecast.ashx?uac=gcV3ynNdoV&output=xml&query=G41");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = sp.getXMLReader();
        handler myHandler = new handler();
        xr.setContentHandler(myHandler);
        xr.parse(new InputSource(url.openStream()));
        parsedDataSet = myHandler.getParsedData();
        tv.setText(parsedDataSet.toString());
    } catch (Exception e) {
        tv.setText("Error: " + e.getMessage());
        Log.e(MY_DEBUG_TAG, "WeatherQueryError", e);
    }

    temp = Integer.parseInt(parsedDataSet.getTemp());
    //...