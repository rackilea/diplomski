public static String getFinalLocation(String address) throws IOException{
    URL url = new URL(address);
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    int status = conn.getResponseCode();
    if (status != HttpURLConnection.HTTP_OK) 
    {
        if (status == HttpURLConnection.HTTP_MOVED_TEMP
            || status == HttpURLConnection.HTTP_MOVED_PERM
            || status == HttpURLConnection.HTTP_SEE_OTHER)
        {
            String newLocation = conn.getHeaderField("Location");
            return getFinalLocation(newLocation);
        }
    }
    return address;
}