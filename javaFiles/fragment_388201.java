Document doc = null;
SAXBuilder builder = new SAXBuilder();
if (file.exists()) {
    doc = builder.build(file);
} else {
    // build a fresh document
    ....
}

// build a new member....

....

// add it to the document
Element members = doc.getRootElement();
members.addContent(newMember);

XMLOutputter xmlout = new XMLOutputter(Format.getPrettyFormat());
try (FileOutputStream fos = new FileOutputStream(file)) {
    xmlout.output(fos, doc);
} catch (IOException ...) {
}