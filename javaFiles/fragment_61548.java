Elements info = doc.select("div[data-brackets-id]");

// iterate the Elements
for(Element elm: info){
    System.out.println(elm.attr("data-brackets-id"));
}