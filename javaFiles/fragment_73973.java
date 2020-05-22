public static void main(String[] args) {

    Document doc;
    try {

        // need http protocol
        doc = Jsoup.connect("https://twitter.com/ATT/").get();

        // get page title
        String title = doc.title();
        System.out.println("title : " + title);

        //select this <p class="js-tweet-text tweet-text"></p>
        Elements links = doc.select("p.js-tweet-text.tweet-text");  

        for (Element link : links) {
            System.out.println("\nlink : " + link.attr("p"));
             /*use ownText() instead of text() in order to grab the direct text of 
             <p> and not the text that belongs to <p>'s children*/
            System.out.println("text : " + link.ownText());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}