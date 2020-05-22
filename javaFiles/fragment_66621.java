String html = "<html>" +
        "<span class=\"arial_20 redFont   pid-348-pc\" dir=\"ltr\">-5.60</span>" +
        "<span class=\"arial_20 redFont \" dir=\"ltr\">55.80</span>" +
        "</html>";

Document doc = Jsoup.parse(html);

// this will print out -5.60 since the only span with a class matching 'arial_20 redFont   pid-*'
// is the one with the value: -5.60
// the other span does not match that CSS selector
String sPriceChange = doc.select("span[class*=\"arial_20 redFont   pid-\"]").text();
System.out.println("Price Change = " + sPriceChange + "\n");