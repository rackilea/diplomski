public static void main(String[] args) {
    final String html = "<td align=\"center\"><a href=\"http://www.zipcodestogo.com/Hialeah/FL/33011/\">33011</a></td> ";
    final Elements elements = Jsoup.parse(html).getElementsMatchingOwnText("^[0-9]{5,5}$");

    for (final Element element : elements) {
        System.out.println("element = [" + element + "]");
        System.out.println("zip = [" + element.text() + "]");
    }
}