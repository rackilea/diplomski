Connection con = Jsoup.connect("http://d.soccer24.com/x/feed/d_hh_K2AUJ0ih_en_2");
    con.header("X-Fsign", "SW9D1eZo");
    Document doc = con.get();
//Your code
Elements elems=doc.select("td.winLose > span.winLoseIcon > a[title]");
for(Element elem:elems){
    System.out.println(elem.attr("title"));
}