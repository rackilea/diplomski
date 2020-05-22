String input = "<div>a</div><p>b</p><strong>c</strong>";


Document doc = Jsoup.parse(input);
Elements elements = doc.select("p ~ *");

Elements group = new Elements();
group.add(elements.first().previousElementSibling());


for( Element element : elements )
{
    group.add(element);
}

// You can work with 'group' too
String output = group.toString();