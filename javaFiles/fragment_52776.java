import org.w3c.dom.Element;
…
if ("media:content".equals(nodeName)) {
    Element contentElement = (Element) thisNode;
    if (contentElement.hasAttribute("url")) {
        String u = contentElement.getAttribute("url");
    }
}