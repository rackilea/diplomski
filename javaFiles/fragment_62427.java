Document doc = Jsoup.connect("http://bulbapedia.bulbagarden.net/wiki/List_of_Pok%C3%A9mon_by_National_Pok%C3%A9dex_number").get();


for( Element element : doc.select("td > span.plainlinks > a") )
{
    /* 
     * You can do further things here - for this example we 
     * only print the absolut url of each link.
     */
    System.out.println(element.absUrl("href"));
}