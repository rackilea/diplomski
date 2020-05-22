public String processWithJSoup() {
        String html = "<html><head><title>First parse</title></head>"
                  + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);

        Elements tags = doc.getAllElements();
        String cleanText = doc.text();

        System.out.println(cleanText);

        for (Element tag : tags) {
            // get node's text
            String nodeText = tag.text();

            // find node's text position in the cleanText for start and end pos

            // get attributes of node

            // create a object to hold the above information

            // push object into an array
        }

        return "";
    }