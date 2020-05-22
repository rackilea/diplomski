/*
 * returns url of search term using jsoup
 */
public static String getUrl(String search) throws IOException{
    String url = "http://wordnetweb.princeton.edu/perl/webwn?s=";
    Document doc = Jsoup.connect(url + search).get();
    String newURL = doc.location().toString();
    System.out.println(newURL);
    return (newURL);
}