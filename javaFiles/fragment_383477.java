org.jsoup.select.Elements all_elements = blogContentDocument.select("*");
for (Element element : all_elements) {
    String escaped = StringEscapeUtils.escapeHtml(element.attr("value"));
    element.attr("value", escaped);
    System.out.println(element);
}

// check if the content is changed in the document
System.out.println(blogContentDocument.html());