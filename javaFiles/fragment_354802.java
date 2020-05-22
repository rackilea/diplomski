Document document = Jsoup.connect("http://example.com/some/page.jsf").get();

for (Element ocrxWord : document.select(".ocrx_word")) {
    String text = ocrxWord.text(); // NAME, FIRSTNAME, etc
    String title = ocrxWord.attr("title"); // bbox 250 192 1606 375; x_wconf 70, etc
    // ...
}