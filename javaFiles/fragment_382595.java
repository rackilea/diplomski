public static String getURLDOI(Record record) {

    String url = indexer.getFirstFieldVal(record,"856u");

    if (url == null)
        return "";

    if (url.substring(0,7).equals("urn:doi")) 
        return "http://hdl.handle.net/"+url.substring(9);

    return url;

}