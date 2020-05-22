Document doc = Jsoup.parseBodyFragment(aText);
Elements el = doc.getAllElements();
for (Element e : el) {
    List<String>  attToRemove = new ArrayList<>();
    Attributes at = e.attributes();
    for (Attribute a : at) {
        // transfer it into a list -
        // to be sure ALL data-attributes will be removed!!!
        attToRemove.add(a.getKey());
    }

    for(String att : attToRemove) {
        e.removeAttr(att);
   }
}


return Jsoup.isValid(doc.body().html(), theLegalWhitelist);