String[] readUrl(String urlStr) throws Exception {
    URL url = new URL(urlStr);
    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
    String result = new String[4];
    for(i=0; i< 4; i++) {
        result[i] = in.readLine();
    }
    return result;
}

String[] tryMultipleUrls(String url1, String url2) {
   String result[] = null;
   try {
       result = readUrl(url1);
   }
   catch(Exception ex) {
       result = readUrl(url2);
   }
   return result;
}