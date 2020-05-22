public static void main(String[] args) {
    String html =   "<table class=\"scl_list\">\n" +
                    "        <tr>\n" +
                    "            <th align=\"center\">Id:</th>\n" +
                    "            <th align=\"center\">Name:</th>\n" +
                    "            <th align=\"center\">Serial:</th>\n" +
                    "            <th align=\"center\">Status:</th>\n" +
                    "            <th align=\"center\">Ladestrom:</th>\n" +
                    "            <th align=\"center\">Z&auml;hleradresse:</th>\n" +
                    "            <th align=\"center\">Z&auml;hlerstand:</th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <th align=\"center\">7</th>\n" +
                    "            <th align=\"center\">7</th>\n" +
                    "            <th align=\"center\">c3001c0020333347156a66</th>\n" +
                    "            <th align=\"center\">Idle</th>\n" +
                    "            <th align=\"center\">16.0</th>\n" +
                    "            <th align=\"center\">40100021</th>\n" +
                    "            <th align=\"center\">12464.25</th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <th align=\"center\">21</th>\n" +
                    "            <th align=\"center\">21</th>\n" +
                    "            <th align=\"center\">c3002a003c343551086869</th>\n" +
                    "            <th align=\"center\">Idle</th>\n" +
                    "            <th align=\"center\">16.0</th>\n" +
                    "            <th align=\"center\">540100371</th>\n" +
                    "            <th align=\"center\">1219.73</th>\n" +
                    "        </tr>\n" +
                    "    </table>";
    Document doc = Jsoup.parse(html);
    Elements trs = doc.select("table.scl_list tr");
    List<List<String>> data = new ArrayList<>();
    for(Element tr : trs){
        List<String> row = tr.select("th").stream().map(e -> e.text())
                                .collect(Collectors.toList());
        data.add(row);
    }
    data.forEach(System.out::println);
}