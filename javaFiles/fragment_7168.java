node.traverse(new TagNodeVisitor() {
    public boolean visit(TagNode tagNode, HtmlNode htmlNode) {
    if (htmlNode instanceof ContentNode) {
            ContentNode content = ((ContentNode) htmlNode); 
            URLConnection urlConn;
            StringBuilder result = new StringBuilder();
            String USER_AGENT =  "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)";
            String text = content.getContent();
            String strUrl = "http://translate.google.com/translate_a/t?client=t&sl=#arguments.FromLanguage#&tl=#arguments.ToLanguage#&hl=#arguments.ToLanguage#&sc=2&ie=UTF-8&oe=UTF-8&oc=1&otf=1&ssel=0&tsel=0&q=" + URLEncoder.encode(text);
            URL url = new URL(strUrl);
            urlConn = url.openConnection();
            urlConn.addRequestProperty("User-Agent",
                            "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            Reader reader = new InputStreamReader(urlConn.getInputStream(),
                            "utf-8");

            JsonArray gRet = new Gson().fromJson(reader, JsonArray.class);
            StringBuffer newContent = new StringBuffer(1000);
            gRet.get(0)?.each() { el -> newContent.append(el.getAsJsonArray()?.get(0)?.getAsString()); };

            tagNode.insertChildAfter(htmlNode, new ContentNode(newContent.toString()));
            tagNode.removeChild(htmlNode);

        }
    }
});