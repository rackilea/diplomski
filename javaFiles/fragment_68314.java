// text element
Element rootElement = null;
if (!fileExist) {
    rootElement = doc.createElement("text");
    doc.appendChild(rootElement);
} else {
    rootElement = doc.getDocumentElement(); // get the root [text] element
}