public class UncommentComments {
        public static void main(String... args) {
            String htmlIn = "<html><head></head><body>"
                    + "<!--<div> hello there </div>-->"
                    + "<div>not a comment</div>"
                    + "<!-- <h5>another comment</h5> -->" 
                    + "</body></html>";
            Document doc = Jsoup.parse(htmlIn);
            List<Comment> comments = findAllComments(doc);
            for (Comment comment : comments) {
                String data = comment.getData();
                comment.after(data);
                comment.remove();
            }
             System.out.println(doc.toString());
        }

        public static List<Comment> findAllComments(Document doc) {
            List<Comment> comments = new ArrayList<>();
            for (Element element : doc.getAllElements()) {
                for (Node n : element.childNodes()) {
                    if (n.nodeName().equals("#comment")){
                        comments.add((Comment)n);
                    }
                }
            }
            return Collections.unmodifiableList(comments);
        }
    }