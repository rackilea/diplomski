try {
    newVersion = Jsoup.connect("https://play.google.com/store/apps/details?id=" + "com.example.myapp" + "&hl=en")
            .timeout(5000)
            .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
            .referrer("http://www.google.com")
            .get()
            .select("div.hAyfc:nth-child(4) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
            .first()
            .ownText();
} catch (Exception e) {
    e.printStackTrace();
}