Document doc;
    for (int page = 1; page < 2; page++) {

        doc = Jsoup.connect("http://hackaday.com/page/" + page).get();

        // get a list of articles on page
        Elements articles = doc.select("main#main article");

        // iterate article list
        for (Element article : articles) {

            // find the article header, which includes title and date
            Element header = article.select("header.entry-header").first();

            // find and scrape title/link from header
            Element headerTitle = header.select("h1.entry-title > a").first();
            String title = headerTitle.text();
            String link = headerTitle.attr("href");

            // find and scrape date from header
            String date = header.select("div.entry-meta > span.entry-date > a").text();

            // find and scrape every paragraph in the article content
            // you probably will want to further refine the logic here
            // there may be paragraphs you don't want to include
            String body = article.select("div.entry-content p").text();

            // view results
            System.out.println(
                    MessageFormat.format(
                            "title={0} link={1} date={2} body={3}", 
                            title, link, date, body));
        }
    }