/**
 * Returns a List ArrayList containing the page source for the supplied web 
 * page link.<br><br>
 * 
 * @param link (String) The URL address of the web page to process.<br>
 * 
 * @return (List ArrayList) A List ArrayList containing the page source for 
 * the supplied web page link.
 */
public static List<String> getWebPageSource(String link) {
    if (link.equals("")) { return null; }
    try {
        URL url = new URL(link);

        URLConnection yc = null;
        //If url is a SSL Endpoint (using a Secure Socket Layer such as https)...
        if (link.startsWith("https:")) {
            yc = new URL(link).openConnection();
            //send request for page data...
            yc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            yc.connect();
        }
        //and if not a SLL Endpoint (just http)...
        else { yc = url.openConnection(); }
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        List<String> sourceText = new ArrayList<>();
        while ((inputLine = in.readLine()) != null) { 
            sourceText.add(inputLine);
        }
        in.close();
        return sourceText;
    } 
    catch (MalformedURLException ex) { 
        // Do whatever you want with exception.
        ex.printStackTrace();
    } 
    catch (IOException ex) { 
        // Do whatever you want with exception.
        ex.printStackTrace();
    }
    return null;
}