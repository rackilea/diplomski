public static void main(String... args) {
        Document doc = Jsoup
                .parse("<html><body><div class=\"text\" id=\"editorText\" itemprop=\"text\">I want to get this Text</div></body></html>");
        Elements divs = doc.select("div#editorText");
        for (Element d : divs) {
            System.out.println(d.text());
        }
    }