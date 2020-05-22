Document doc = null;
try {
    doc = Jsoup
            .connect(
                    "http://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=0&type=8&season=2015&month=0&season1=2015&ind=0&team=18&rost=0&age=0&filter=&players=0")
            .get();
}
catch (IOException ioe) {
    ioe.printStackTrace();
}

Element table = doc.getElementById("LeaderBoard1_dg1_ctl00");
Elements rows = table.getElementsByTag("tr");
for (Element row : rows) {
    Elements tds = row.getElementsByTag("td");
    for (int i = 0; i < tds.size(); i++) {
        System.out.println(tds.get(i).text());
    }
}