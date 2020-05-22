// instantiate the tsdbElementsData list
List<TsdbElements> tsdbElementsData = new ArrayList<>(TsdbElements)

for (Ingestion ingestion: ingestionData)
{
    // get the elements
    tsdbElements = ingestion.getTsdbElements();

    // do some with the elements, e,g add to a another list
    tsdbElementsData.add(tsdbElements);
}