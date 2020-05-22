// Select the table with class 'shipinfo'
Elements tables = doc.select("table.shipinfo");

// Iterate over all tables found (since it's only one, you can use first() instead
for( Element element : tables )
{
    // Select all 'td' tags of that table
    Elements tdTags = element.select("td"); 

    // Iterate over all 'td' tags found
    for( Element td : tdTags )
    {
        // Print it's text if not empty
        final String text = td.text();

        if( text.isEmpty() == false )
        {
            System.out.println(td.text());
        }
    }
}