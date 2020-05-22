String html = "<div>\n textA\n <table>\n <tbody>\n <tr>\n <td>textB</td>\n </tr>\n </tbody>\n </table>\n textC\n</div>";

Document doc = Jsoup.parse(html);

Element div =doc.select("div").first();
if (div!=null) {
    String[] splittedParts = div.text().split("(?=textC)");

    for(String s:splittedParts) {
        System.out.println(s);                
    }
}