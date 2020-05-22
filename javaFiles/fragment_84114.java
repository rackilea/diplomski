public String searchDirectory() throws IOException {
    URL url = new URL("https://www.xxxxx.com/xxxxx/xxxxx.cgi");
    URLConnection con = url.openConnection();
    con.setDoInput(true);
    con.setDoOutput(true);
    con.setUseCaches(false);
    con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

    DataOutputStream printout = new DataOutputStream (con.getOutputStream ());

    String parameters =("name=" + URLEncoder.encode("DATA HERE", "UTF-8"));
    printout.writeBytes (parameters);
    printout.flush ();
    printout.close ();
        /*InputStream inputStream = getApplicationContext().getResources().getAssets().open("White Pages Query Results.html");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        */
    DataInputStream input = new DataInputStream (con.getInputStream ());
    String line;
    String htmlCode = "";
    while((line = input.readLine()) != null) {
        htmlCode += line;
    }
    return htmlCode;
}