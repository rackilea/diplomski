private static String test(String htmlFile) {
    File input = null;
    Document doc = null;
    Elements tdEles = null;
    Element table = null;
    String tdContents = "";

    try {
        input = new File(htmlFile);
        doc = Jsoup.parse(input, "ASCII", "");
        doc.outputSettings().charset("ASCII");
        doc.outputSettings().escapeMode(EscapeMode.base);

        /** Get table with id = box-table-a **/
        table = doc.getElementById("box-table-a");

        if (table != null) {
            /** Get td tag elements **/
            tdEles = table.getElementsByTag("td");

            /** Loop each of the td element and get the content by ownText() **/
            if (tdEles != null && tdEles.size() > 0) {
                for (Element e: tdEles) {
                    String ownText = e.ownText();

                    //Delimiter as "||"
                    if (ownText != null && ownText.length() > 0)
                        tdContents += ownText + "||";
                }

                if (tdContents.length() > 0) {
                      tdContents = tdContents.substring(0, tdContents.length() - 2);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return tdContents;
}