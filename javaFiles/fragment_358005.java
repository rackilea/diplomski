String url = "https://stackoverflow.com/questions/50083471/input-in-html-to-java-file";
Document doc = Jsoup.parse(new URL(url), 3000);
System.out.println("title: " + doc.select("title").text());
System.out.println("users:");
for (Element e : doc.select("div.user-details a"))
    System.out.println("    " + e.text());