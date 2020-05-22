String html = "<span style=\"font-weight: bold;text-decoration-line: underline;\">test</span><p><span>&nbsp;</span></p><p><span>Table</span></p>";

    Document doc = Jsoup.parse(html);

    for (Element span : doc.getElementsByTag("span")) {
        if (span.attributes().size() == 0) {
            span.unwrap();
        }
    }

    doc.outputSettings().prettyPrint(false);

    String result = doc.body().html();