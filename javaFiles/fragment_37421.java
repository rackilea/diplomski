final String html = "<div>\n"
        + "    this is first\n"
        + "    <div>\n"
        + "        second\n"
        + "   </div>\n"
        + "</div>";

Document doc = Jsoup.parse(html); // Get your Document from somewhere


Element first = doc.select("div").first(); // Select 1st element - take the first found
String firstText = first.ownText(); // Get own text

Element second = doc.select("div > div").first(); // Same as above, but with 2nd div
String secondText = second.ownText();

System.out.println("1st: " + firstText);
System.out.println("2nd: " + secondText);