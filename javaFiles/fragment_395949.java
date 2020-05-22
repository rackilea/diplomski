Document document = Jsoup.parse(html);
Elements selector = document.select("meta[name=GENERATOR]");

for (Element element : selector) {
    element.remove();
}

doc.html(); // returns String html with elements removed