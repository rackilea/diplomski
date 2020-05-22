String html = "<table><tr><td>1</td><td>2</td></tr><tr><td>3</td><td>4</td></tr></table>";
    Document doc = Jsoup.parse(html);
    System.out.println(doc);
    Elements elements = doc.select("tr td:last-child");
    for(Element element: elements) {
        System.out.println(element.html());
    }