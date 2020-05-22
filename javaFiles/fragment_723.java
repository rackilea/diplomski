Document doc = Jsoup.parse(html); // Init the DOM structure
Elements hs = doc.select("*[id]");   // Find all tags with `id` attribute
for(int i = 0; i < hs.size(); i++){  // Iterate through the tags 
    Element h = hs.get(i);           // Get the current element
    if (h.tagName().matches("h\\d+")) { // If its tag is a heading tag
        String new_val = h.attr("id").replace("ä", "ae").replace("ö", "oe").replace("ü", "ue");
        h.attr("id",new_val);  // Replace the id attribute with a new one
    }
}
System.out.println(doc.toString());