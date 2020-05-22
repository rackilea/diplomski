URI docURI = URI.create(webView.getEngine().getLocation());

int count = frames.getLength();
for (int i = 0; i < count; i++) {
    Element frame = (Element) frames.item(i);
    URI frameLocation = docURI.resolve(frame.getAttribute("src"));
    // Show frameLocation in new window...
}