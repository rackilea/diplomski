Document doc = Jsoup.parse(new URL("http://www.bits4beats.it/"), 2000);

    Elements resultLinks = doc.select("a");
    System.out.println("number of links: " + resultLinks.size());
    for (Element link : resultLinks) {
        System.out.println();
        String href = link.attr("href");
        System.out.println("Title: " + link.text());
        System.out.println("Url: " + href);
    }