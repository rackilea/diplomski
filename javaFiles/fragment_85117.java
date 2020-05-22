Document doc = engine.getDocument();
if (doc != null){
    Element elem = doc.getElementById('someID'); 
    String classNames = elem.getAttribute("class");
    classNames += " someClass"; //note the whitespace!
    elem.setAttribute("class", classNames);
}