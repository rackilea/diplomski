HttpClient http = new DefaultHttpClient();
String htmlcode = "";
HttpGet request = new HttpGet("http://www.example.com");
HttpResponse response = null;
try {
    response = http.execute(request);
} catch (ClientProtocolException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
if(response != null){
    BufferedReader read = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

    String line = "";
    while((line = read.readLine()) != null){
        htmlcode += line; 
    }
}
// at this point we have the pages markup
Document doc = Jsoup.parse(htmlcode);
Elements lis = doc.getElementsByTag("li"); // get all entries in lists
for(Element el : lis){
    String val = el.text().trim();
    // do something for each list entry
}