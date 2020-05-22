List<String> list = new ArrayList<>(); // Better than an array

Document doc = Jsoup.connect("http://maps.google.co.in/maps?hl=en&q=nagpur+to+pune").get(); // Connect to url and parse its conntent
Elements el = doc.select("*.dir-mrgnr"); // Every tag with 'dir-mrgnr' class - or use getElementsByClass() as you did

for( Element element : el )
{
    list.add(element.text());
}