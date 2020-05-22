public class JsoupDepthFirst {

    private static String htmlTags(Document doc) {
        StringBuilder sb = new StringBuilder();
        htmlTags(doc.children(), sb);
        return sb.toString();
    }

    private static void htmlTags(Elements elements, StringBuilder sb) {
        for(Element el:elements) {
            if(sb.length() > 0){
                sb.append(",");
            }
            sb.append(el.nodeName());
            htmlTags(el.children(), sb);
            sb.append(",").append(el.nodeName());
        }
    }

    public static void main(String... args){
        String s = "<html><head>this is head </head><body>this is body</body></html>";
        Document doc = Jsoup.parse(s);
        System.out.println(htmlTags(doc));
    }
}