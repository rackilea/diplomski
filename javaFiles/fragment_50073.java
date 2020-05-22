String ua = "Mozilla/5.0 ;Windows NT 6.1; "
     + "WOW64; AppleWebKit/537.36 ;KHTML, like Gecko; "
     + "Chrome/39.0.2171.95 Safari/537.36";
Document doc = Jsoup.connect(url)
        .userAgent(ua)
        .get();
Elements links = doc.select("span.bluetext");