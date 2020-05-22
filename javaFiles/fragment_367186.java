Pattern pattern = Pattern.compile("[\\w-]+(\\.[\\w-]+)*\\s?@\\s?[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,4})");
Document doc = cleaner.clean(Jsoup.connect(url).get());
String text = doc.text();
Matcher matcher = pattern.matcher(text);
while (matcher.find()) {
    System.out.println(matcher.group());
}