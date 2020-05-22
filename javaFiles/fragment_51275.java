boolean validateHtml(String html) {
  Document doc = Jsoup.parse(html);
  for(Element e : doc.getAllElements()) {
      if(detectJavascript(e)) {
          return false;
      }
  }
  return true;
}

private boolean detectJavascript(Element e) {
  if(/* Check if element contains javascript */) {
      return true;
  }
  return false;
}