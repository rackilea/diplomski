Elements elems = doc.getElementsByTag("style"); //Select "style" element
for (Element elem : elems) {
    Node child = elem.childNode(0);
    String styleText = child.attr("data").replaceAll("background-color:\\s*#[a-f0-9]+;", ""); //Remove background color attribute
    child.attr("data", styleText); //Set the updated style back into the element
}
System.out.println(doc);