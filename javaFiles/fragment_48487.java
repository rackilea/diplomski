final String url = "http://www.nytimes.com/";
Document doc = Jsoup.connect(url).get();

for( Element element : doc.select("p.summary") )
{
    if( element.hasText() ) // Skip those tags without text
    {
        System.out.println(element.text());
    }
}