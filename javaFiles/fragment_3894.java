public static String makeHTML(String htmlText){
    boolean isValidDoc = false;
    if((htmlText.contains("<html") || htmlText.contains("<HTML")) && 
            (htmlText.contains("<head") || htmlText.contains("<HEAD")) &&
            (htmlText.contains("<body") || htmlText.contains("<BODY"))){
        isValidDoc = true;
    }

    Document doc = Jsoup.parseBodyFragment(htmlText);
    final String urlRegex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    final List<TextNode> nodesToChange = new ArrayList<>();
    final List<String> changedContent = new ArrayList<>();

    NodeTraversor nd  = new NodeTraversor(new NodeVisitor() {

        @Override
        public void tail(Node node, int depth) {
            if (node instanceof TextNode) {
                TextNode textNode = (TextNode) node;
                Node parent = node.parent();
                if(parent.nodeName().equals("a")){
                    return;
                }

                String text = textNode.getWholeText();

                List<String> allMatches = new ArrayList<String>();
                Matcher m = Pattern.compile(urlRegex)
                        .matcher(text);
                while (m.find()) {
                    allMatches.add(m.group());
                }

                if(allMatches.size() > 0){
                    String result = text;
                    for(String match : allMatches){
                        result = result.replace(match, "<a href=\"" + match + "\">" + match + "</a>");
                    }
                    changedContent.add(result);
                    nodesToChange.add(textNode);
                }
            }
        }

        @Override
        public void head(Node node, int depth) {        
        }
    });

    nd.traverse(doc.body());

    int count = 0;
    for (TextNode textNode : nodesToChange) {
        String result = changedContent.get(count++);
        Node newNode = new DataNode(result, textNode.baseUri());
        textNode.replaceWith(newNode);
    }

    String processed = doc.toString();
    if(!isValidDoc){
        int start = processed.indexOf("<body>") + 6;
        int end = processed.lastIndexOf("</body>");
        processed = processed.substring(start, end);
    }

    return processed;
}