download(String toplevelURI, int level) {
  if (level > MAX_LEVEL) {
    return; //termination condition
  }
  Document doc = Jsoup.connect(url).get();
  Elements links = doc.getElementsByTag("a");
  for (Element link : links) {
     String url = link.absUrl("href");
     link.add(url); //store the current level of link
     download(url, level++); //get all children of current link
  }
}