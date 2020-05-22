public static Map<String, String> getFormParams(final Document doc) {
        return doc.select("div.nav-link > form")
                .first()
                .select("input")
                .stream()
                .filter((input) -> {
                    return input.attr("name") != null && !input.attr("name").equals("");
                })
                .collect(Collectors.toMap(input -> input.attr("name"), input -> input.attr("value")));
    }

    public static void main(final String... args) throws IOException {
        final String baseURL = "https://duckduckgo.com/html";
        final Connection conn = Jsoup.connect(baseURL)
                .userAgent("Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
        conn.data("q", "search phrase"); // Change "search phrase"

        // 1st page
        final Document page1 = conn.get();

        final Map<String, String> formParams
                = getFormParams(page1);

        // 2nd page
        final Document page2 = conn.data(formParams).get();
    }