@CrossOrigin(origins = "*")
@RequestMapping(value = { "/getAccess" }, method = RequestMethod.GET)
public void authenticate() throws IOException {
    try {
        OneDriveSDK sdk = OneDriveFactory.createOneDriveSDK(CLIENT_ID, SECRET, REDIRECT_URI,
                OneDriveScope.READWRITE);
        String url = sdk.getAuthenticationURL();
        logger.info(url);
        openWebpage(url);
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Access-Control-Allow-Origin", "*");
        con.setDoOutput(true);
        int responseCode = con.getResponseCode();
        logger.info("REQUEST SENT. Response Code : " + responseCode);
    } catch (Exception e) {
        e.printStackTrace();
    }
}