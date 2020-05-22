public void searchForItems(Document doc)
{
    Elements tables = doc.select("li[class=TABLE]");
    for (Element table : tables)
    {

        String item;
        Elements itemsInTable = table.select("span[class=item]");
        item = itemsIntTable.text();


        //Write the item to file. Depending on what is in your table, you might
        //have to write a more complex scan. Looking for things like attributes
    }
}