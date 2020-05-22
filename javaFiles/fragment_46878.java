File input = new File("shipMove.txt");
Document doc = Jsoup.parse(input, null);


Elements matches = doc.select("<your selector here>");

for( Element element : matches )
{
    // do something with found elements
}