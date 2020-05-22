Element tableHeader = doc.select("tr").first();


for( Element element : tableHeader.children() )
{
    // Here you can do something with each element
    System.out.println(element.text());
}