@Test
public void parseInputValueFromHtml() {
    String html = "<input type = \"text\" id = \"national\" value = \"3.26\" style = \"width: 2.3em;\">";

    Document document = Jsoup.parse(html);

    Element mdolar = document.getElementById("national");
    Assert.assertEquals("3.26", mdolar.attr("value"));

    // you can also find this element by type:
    Elements mdolars = document.select("input[id=national]");
    Assert.assertEquals(1, mdolars.size());
    Assert.assertEquals("3.26", mdolars.first().attr("value"));
}