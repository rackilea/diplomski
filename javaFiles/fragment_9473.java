public void startElement (String uri, String name, String qName, Attributes atts) {
    if (qname.equals("RegionName") {
        regionName = atts.getValue(0);
    }
    if (qname.equals("RegionId") {
        regionId = Integer.parseInt(atts.getValue(0));
    }
    if (qname.equals ("Status") {
        if(regionName.equals ("New England")) {
            //Do what you want here
        }

    }

}