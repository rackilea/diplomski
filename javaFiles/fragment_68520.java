public static void main(String[] args) {
    System.out.println(download("https://webapp4.asu.edu/catalog/classlist?c=TEMPE&s=CSE&n=100&t=2141&e=open&hon=F"));
}

static String download(String urlToRead) {
    java.net.CookieManager cm = new java.net.CookieManager();
    java.net.CookieHandler.setDefault(cm);
    String result = "";
    try {
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Cookie", "onlineCampusSelection=C");

        BufferedReader rd = new BufferedReader(new InputStreamReader(
                conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result += line + "\n";
        }
        rd.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return result;
}