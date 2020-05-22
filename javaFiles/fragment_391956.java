final WebClient webClient = new WebClient();
webClient.setJavaScriptEnabled(false);
final HtmlPage page = webClient.getPage("http://www.placeofjo.blogspot.com/");

//  Then iterate through
for (DomElement element : page.getElementsByTagName("a")){
    String link = ((HtmlAnchor)element).getHrefAttribute();
    System.out.println(link);
}