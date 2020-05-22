try
{
    Document doc = Jsoup.connect(urlget).get();
    Elements tables = doc.select("div.itembody");
    if(tables.isEmpty())
        noDivItembodyInHTML();
    else
        websiteaddress = tables.first().text();
}
catch (IOException ee)
{
}