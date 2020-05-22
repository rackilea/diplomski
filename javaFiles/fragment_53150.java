String packageName = "com.facebook.katana";

Document doc = Jsoup.connect("http://apk-dl.com/" + packageName).get();
Elements data = doc.select(".file-list .mdl-menu__item");

if (data.size() > 0) {
    System.out.println("full text : " + data.get(0).text());
    Pattern pattern = Pattern.compile("(.*)\\s+\\((\\d+)\\)");
    Matcher matcher = pattern.matcher(data.get(0).text());
    if (matcher.find()) {
        System.out.println("version name : " + matcher.group(1));
        System.out.println("version code : " + matcher.group(2));
    }
}