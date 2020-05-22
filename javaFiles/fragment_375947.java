for (Element element : elements) {
    if ("a".equalsIgnoreCase(element.tagName()) {
        try (PrintWriter writer2 = new PrintWriter("contenthtml.html", "UTF-8")) {
            writer2.print(a.ExtractHTMLByIDandDomain(Domain + element.attr("href"), Content_HTML_ID));
        }
    }
    Process proc = Runtime.getRuntime().exec("/usr/bin/bash run.sh");
}