File input = new File("input.html");
    Document doc = Jsoup.parse(input, "UTF-8", "");
    Element span = doc.select("span:containsOwn(Campaign0)").first();
    span.wrap("<a href=\"First.html\"></a>");
    span = doc.select("span:containsOwn(Campaign1)").first();
    span.wrap("<a href=\"Second.html\"></a>");
    String html = doc.html();
    BufferedWriter htmlWriter =
            new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.html"), "UTF-8"));
    htmlWriter.write(html);
    htmlWriter.close();