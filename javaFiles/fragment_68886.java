/**
 * This method will take the supplied URL String regardless of the protocol (http or https)
 * specified at the beginning of the string, and will return whether or not it is an actual
 * "http" (no SSL) or "https" (is SSL) protocol. A connection to the URL is attempted first 
 * with the http protocol and if successful (by way of data acquisition) will then return 
 * that protocol. If not however, then the https protocol is attempted and if successful then 
 * that protocol is returned. If neither protocols were successful then Null is returned.<br><br>
 * 
 * Returns null if the supplied URL String is invalid, a protocol does not
 * exist, or a valid connection to the URL can not be established.<br><br>
 * 
 * @param webLink (String) The full link path.<br>
 * 
 * @return (String) Either "http" for Non SLL link, "https" for a SSL link. 
 * Null is returned if the supplied URL String is invalid, a protocol does 
 * not exist, or a valid connection to the URL can not be established.
 */
public static String isHttpOrHttps(String webLink) {
    URL url;
    try {
        url = new URL(webLink);
    } catch (MalformedURLException ex) { return null; }

    String protocol = url.getProtocol();
    if (protocol.equals("")) { return null; }

        URLConnection yc;
        try {
            yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            in.close();
            return "http";
        } catch (IOException e) {
            // Do nothing....check for https instead.
        }
        try {
            yc = new URL(webLink).openConnection();
            //send request for page data...
            yc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            yc.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            in.close();
            return "https";
        } catch (IOException e) {
            // Do Nothing....allow for Null to be returned.
        }
    return null;
}