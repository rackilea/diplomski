public static class Traverser implements NodeVisitor {

        StringBuilder extractHtmlBuilder = new StringBuilder();

        @Override
        public void head(Node node, int depth) {
            if (node instanceof Element && !(node instanceof Document)) {
                extractHtmlBuilder.append("<").append(node.nodeName()).append(node.attributes()).append(">");
            }
        }

        @Override
        public void tail(Node node, int depth) {
            if (node instanceof Element && !(node instanceof Document)) {
                extractHtmlBuilder.append("</").append(node.nodeName()).append(">");
            }
        }
    }