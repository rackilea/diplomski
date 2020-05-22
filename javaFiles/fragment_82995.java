public void parseXMLFile(String fullpath) {
    String metadata_name = null;
    String metadata_link_href = null;
    String metadata_link_name = null;
    String metadata_time = null;
    String point_lat = null;
    String point_lon = null;
    String last_lat = null;
    String last_lon = null;
    String point_name = null;
    String point_cmt = null;
    String fileContents = null;

    try {
        fileContents = readFileAsString(fullpath);

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    try {
        Document doc = (Document) loadXMLFromString(fileContents);

        for (Match metadata : $(doc).find("metadata").each()) {
            Match c = metadata.children();
            for (int i = 0; i < c.size(); i++) {
                metadata_name = c.find("name").text();
                metadata_link_href = c.find("link").attr("href").toString();
                metadata_link_name = c.find("link").find("text").text();
                metadata_time = c.find("time").text();
            }
        }

        for (Match rte2 : $(doc).xpath("//rte").andSelf().each()) {
            rte2.children();
            for(Match rtetag : rte2.children().each()) {
                if(rtetag.tag().equalsIgnoreCase("name")) {
                    rtetag.text();
                }
                if(rtetag.tag().equalsIgnoreCase("rtept")) {
                    for(Match rtepttag : rtetag.children().andSelf().each()) {
                        if(rtepttag.tag().equals("name")) {
                            point_name = rtepttag.text();
                        }
                        if(rtepttag.tag().equals("cmt")) {
                            point_cmt = rtepttag.text();
                        }
                        if(rtepttag.tag().equals("rtept")) {
                            if(last_lon == null) {
                                last_lon = point_lon;
                            }
                            if(last_lat == null) {
                                last_lat = point_lat;
                            }
                            point_lat = rtepttag.attr("lat");
                            point_lon = rtepttag.attr("lon");

                            //done parsing? here's some log stuff to check
                             Log.d("XML", "META_NAME:" + metadata_name);
                             Log.d("XML", "META_LINK_HREF:" + metadata_link_href);
                             Log.d("XML", "META_LINK_NAME:" + metadata_link_name);
                             Log.d("XML", "META_TIME:" + metadata_time);
                             Log.d("XML", "POINT_NAME:" + point_name);
                             Log.d("XML","POINT_CMT:"+point_cmt);
                             Log.d("XML", "POINT_LAT:" + point_lat);
                             Log.d("XML", "POINT_LON:" + point_lon);

                        }
                    }
                }
            }
        }


    } catch (Exception e) {
        String estr = e.getStackTrace().toString();
        Log.d("XML", "XML Exception: " + e + ":" + estr);
    }
}