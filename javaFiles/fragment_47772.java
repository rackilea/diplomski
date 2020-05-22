Document doc = // parse your document here or connect to a website


for( Element element : doc.select("div.detNane") )
{
    System.out.println(element.text()); // Print the text of that element
}