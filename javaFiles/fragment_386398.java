String URL_czech = "https://en.wikipedia.org/wiki/Hudson+Township+%28disambiguation%29";

URL wikidata_page = new URL(URL_czech);
HttpURLConnection wiki_connection = (HttpURLConnection)wikidata_page.openConnection();
InputStream wikiInputStream = null;

try {
    // try to connect and use the input stream
    wiki_connection.connect();
    wikiInputStream = wiki_connection.getInputStream();
} catch(IOException e) {
    // failed, try using the error stream
    wikiInputStream = wiki_connection.getErrorStream();
}
// parse the input stream using Jsoup
Jsoup.parse(wikiInputStream, null, wikidata_page.getProtocol()+"://"+wikidata_page.getHost()+"/");