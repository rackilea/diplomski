for (Element table : doc.select("table")) {
        for (Element row : table.select("tr")) {
            Elements tds = row.select("td");
            formNumber = tds.get(0).text();
            title = tds.get(1).text();
            link1 = tds.get(2).select("a[href]").attr("href");
            link2 = tds.get(3).select("a[href]").attr("href");
            }
}