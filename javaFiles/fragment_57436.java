String encodedUrl = URLEncoder.encode("http://www.example.com/q=Türk&#231e", "ISO-8859-3");
String encodedBaseUrl = URLEncoder.encode("http://www.example.com/q=", "ISO-8859-3");
String query = encodedUrl.replace(encodedBaseUrl, "");

Document doc= Jsoup.connect("http://www.example.com")
        .data("q", query)
        .get();