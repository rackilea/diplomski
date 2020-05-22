/*
 * returns true if is a word
 */
public static boolean isWord(String search) throws IOException{

    String url = "http://wordnetweb.princeton.edu/perl/webwn?s=";
    String notAWord = "Your search did not return any results.";

    Document doc = Jsoup.connect(url + search).get();
    String searchH3 = doc.select("h3").text();

    return searchH3.contains(notAWord) ? false : true;

}