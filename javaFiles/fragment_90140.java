public static ArrayList<String> autocompleteResults(String query) 
        throws IOException, UnsupportedEncodingException, PatternSyntaxException {
    String url = "https://clients1.google.com/complete/search?client=youtube&hl=en&gs_rn=64&gs_ri=youtube&ds=yt&cp=10&gs_id=b2&q=";
    String re = "\\[\"(.*?)\",";

    Response resp = Jsoup.connect(url + URLEncoder.encode(query, "UTF-8")).execute();
    Matcher match = Pattern.compile(re, Pattern.DOTALL).matcher(resp.body());

    ArrayList<String> data = new ArrayList<String>();
    while (match.find()) {
        data.add(match.group(1));
    }
    return data;
}