public static void main(String[] args) {
    try {
        String url = "http://cell-phone-providers-review.toptenreviews.com/cingular-review.html";
        Document doc = Jsoup.connect(url).get();
        Elements paragraphs = doc.select("p");
        PrintWriter out = new PrintWriter(new FileWriter("C:/Users/Desktop/outputtext.txt")); 
        for(Element p : paragraphs) {
            out.print(p.text());
        }
        out.close();          
    } catch (IOException ex) {
        Logger.getLogger(Htmlparser.class.getName()).log(Level.SEVERE, null, ex);
    }
}