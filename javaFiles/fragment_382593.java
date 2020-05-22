public static String getURLDOI(String record) {
    String url = record;
    if (url != null) {
        if (url.substring(0,7).equals("urn:doi")) {
            String result = "http://hdl.handle.net/"+url.substring(9);
            return result;
        } else {
            String result = url;
            return result;
        }
        return "";
    }
}