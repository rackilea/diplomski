public static String setExternalLinkTargets(String html) {
    final NodeVisitor linkVisitor = new NodeVisitor() {

        @Override
        public void visitTag(Tag tag) {
            // Process any tag/node in your HTML 
            String name = tag.getTagName();

            // Set the Link's target to _blank if the href is external
            if ("a".equalsIgnoreCase(name)) {
                if(isExternalLink(url.getHost()) {
                    tag.setAttribute("target", "_blank");
                }
            }
        }
    };

    Parser parser = Parser.createParser(html, null);
    NodeList list;
    try {
        list = parser.parse(null);
        list.visitAllNodesWith(linkVisitor);
        return list.toHtml();
    } catch (ParserException e) {
        // Could not parse HTML, return original HTML
        return html;
    }
}