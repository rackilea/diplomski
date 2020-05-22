public class Test {
    public static void main(String[] args) {
        String html ="<table class=\"selectiontable\">\n" +
                "<tr>\n" +
                "  <td class=\"leftcell\" valign=\"top\">\n" +
                "  <div onclick=\n" +
                "  \"ShowHideTravelDetails('bookingPrice_TaxesToggleBox', \n" +
                "'bookingPrice_TaxesToggleIcon', '/Images');\" class=\"productheader\">...</div>\n" +
                "</td>\n" +
                "<td class=\"rightcell emphasize\" align=\"right\" \n" +
                "valign=\"bottom\">$23.90</td></tr>\n" +
                "</table>";


        Document document = Jsoup.parse(html);
        Elements elements = document.select(".selectiontable");
         for (Element element :elements){
             for (Element row : element.select("tr")) {
                 Elements tds = row.select("td");
                 if (tds.size() > 1) {
                     System.out.println(tds.get(1).text());
                 }
             }
         }
    }


}