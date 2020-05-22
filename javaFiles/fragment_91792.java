private Document downloadPage(int pageNumber) throws IOException {
    Document d = Jsoup.connect(USGS).get(); // first request to get <form> and it's hidden values
    Elements inputs = d.select("#form1 input");
    Connection connectionWithData = Jsoup.connect(USGS);
    for (Element input : inputs) {
        if (input.attr("name").equals("__EVENTTARGET") || input.attr("name").equals("__EVENTARGUMENT")) { // skipping these two params as we will fill them below
            continue;
        }
        connectionWithData.data(input.attr("name"), input.attr("value"));
    }
    return connectionWithData
        .data("__EVENTTARGET", "PassListView1")
        .data("__EVENTARGUMENT", "Page$" + pageNumber)
        .post();
}