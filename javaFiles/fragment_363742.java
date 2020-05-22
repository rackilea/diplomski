//select the div with the item list
    Element itemlist = doc.select("div.itemlist").first();
    // select each li element
    Elements items = itemlist.select("li");
    // for each li element select the corresponding div with item name, shipping info and price 
    for(Element e : items){
        System.out.println(e.select("div.Description h2").text());
        System.out.println(e.select("div.Description h3").text());
        System.out.println(e.select("div.currency-USD").text());
    }