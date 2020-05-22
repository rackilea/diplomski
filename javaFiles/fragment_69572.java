String wrapped = "<dummy>" + text + "</dummy>";
Document parsed = builder.parse(new InputSource(new StringReader(wrapped)));
DocumentFragment fragment = parsed.createDocumentFragment();

// Here, the document element is the <dummy/> element.
NodeList children = parsed.getDocumentElement().getChildNodes();

// Move dummy's children over to the document fragment
while (children.getLength() > 0) {
    fragment.appendChild(children.item(0));
}