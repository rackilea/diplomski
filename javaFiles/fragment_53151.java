String packageName = "com.facebook.katana";

Elements data = Jsoup.connect("https://apkpure.com/search?q=" + packageName)
        .userAgent("Mozilla")
        .get().select(".search-dl .search-title a");

if (data.size() > 0) {

    Elements data2 = Jsoup.connect("https://apkpure.com" + data.attr("href"))
            .userAgent("Mozilla")
            .get().select(".faq_cat dd p");

    if (data2.size() > 0) {
        System.out.println(data2.get(0).text());

        Pattern pattern = Pattern.compile("Version:\\s+(.*)\\s+\\((\\d+)\\)");
        Matcher matcher = pattern.matcher(data2.get(0).text());
        if (matcher.find()) {
            System.out.println("version name : " + matcher.group(1));
            System.out.println("version code : " + matcher.group(2));
        }
    }
}