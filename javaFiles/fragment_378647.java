public static void main(String[] args) {

    String html = "<html><head><title>The Title</title></head>"
              + "<body><p><a href=\"/data/abstract/ash/2014/5/9/Paper_69295_abstract_120490_0.gif\" target=\"_blank\"><img width=\"437\" src=\"/data/abstract/ash/2014/5/9/Paper_69295_abstract_120490_0.gif\" height=\"418\" class=\"documentimage\"></a></p></body></html>";
    Document doc = Jsoup.parse(html,"https://whatever.com"); 

    Elements select = doc.select("a");
    for (Element e : select){
        // baseUri will be used by absUrl
        String absUrl = e.absUrl("href");
        e.attr("href", absUrl);
    }

    //now we process the imgs
    select = doc.select("img");
    for (Element e : select){
        e.attr("src", e.absUrl("src"));
    }

    System.out.println(doc);        
}