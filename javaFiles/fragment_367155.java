List<Entry> entries = new ArrayList<>();        // All entries are saved here
boolean firstSkipped = false;                   // Used to skip first 'tr' tag


for( Element element : doc.select("tr") )       // Select all 'tr' tags from document
{
     // Skip the first 'tr' tag since it's the header
    if( !firstSkipped )
    {
        firstSkipped = true;
        continue;
    }

    int index = 0;                              // Instead of index you can use 0, 1, 2, ...
    Entry tableEntry = new Entry();
    Elements td = element.select("td");         // Select all 'td' tags of the 'tr'

    // Fill your entry
    tableEntry.setKlasse(td.get(index++).text());
    tableEntry.setStunde(td.get(index++).text());
    tableEntry.setLehrer(td.get(index++).text());
    tableEntry.setFach(td.get(index++).text());
    tableEntry.setRaum(td.get(index++).text());
    tableEntry.setvLehrer(td.get(index++).text());
    tableEntry.setvFach(td.get(index++).text());
    tableEntry.setInfo(td.get(index++).text());

    entries.add(tableEntry);                    // Finally add it to the list
}