Elements elem = doc.select("eta");
Iterator<Element> iterator = elem.iterator();
while(iterator.hasNext()) {
    Element etaElement = iterator.next();
    Element arrT = etaElement.select("arrT");    
    Element prdt = etaElement.select("prdt");
    //  1. parse the arrT value
    //  2. parse the prdt value
    //  3. subtract them.
}