void readPage(int page) throws IOException {
    URL url = new URL("http://www.top1000.ie/companies?page=" + page);

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setDoOutput(true);
    connection.setRequestMethod("POST");

    try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
        // no need to post any data for this page
        writer.write("");
    }

    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
        try (Reader reader = new InputStreamReader(connection.getInputStream())) {
            String html = Json
                .parse(reader)
                .asObject()
                .getString("html", "");

            Elements companies = Jsoup
                .parse(html)
                .body().select(".content .name");

            for (Element company : companies) 
                System.out.println("Company: " + company.text());
        }
    } else {
        // handle HTTP error code.
    }
}