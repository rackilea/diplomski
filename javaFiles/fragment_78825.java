Elements bodyChildElements = doc.body().children();

for(Element e : bodyChildElements){
    if(!e.tagName().equals("div")){ 
        e.remove();
    }
    else if(!e.attr("id").equals("abc") && !e.attr("id").equals("xyz")){
        e.remove();
    }
}
System.out.println(doc.html());