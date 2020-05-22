public String getResponse(String url, int timeout) {
    HttpURLConnection c;
    try {
        URL u = new URL(url);
        c = (HttpURLConnection) u.openConnection();
        c.setRequestMethod("GET");
        c.setRequestProperty("Content-length", "0");
        c.setUseCaches(false);
        c.setAllowUserInteraction(false);
        c.setConnectTimeout(timeout);
        c.setReadTimeout(timeout);
        c.connect();
        int status = c.getResponseCode();

        switch (status) {
            case 200:
            case 201:
                BufferedReader br = new BufferedReader(new              InputStreamReader(c.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }
                br.close();
                return sb.toString();
       default:
        return "HTTP CODE: "+status;
        }

    } catch (MalformedURLException ex) {
        Logger.getLogger(DebugServer.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(DebugServer.class.getName()).log(Level.SEVERE, null, ex);
    } finally{
       if(c!=null) c.disconnect();
    }
    return null;
}