public static class SecondSolution implements NodeVisitor {

        StringBuilder sb = new StringBuilder();

        @Override
        public void head(Node node, int depth) {
            if (node instanceof Element && !(node instanceof Document)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(node.nodeName());
            }
        }

        @Override
        public void tail(Node node, int depth) {
            if (node instanceof Element && !(node instanceof Document)) {
                sb.append(",").append(node.nodeName());
            }
        }
    }