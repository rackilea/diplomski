@Test
public void sort() throws IOException
{
    CsvMapper csvMapper = new CsvMapper();
    CsvSchema schema = csvMapper
        .typedSchemaFor(PersonDetailsCSVTemplate.class)
        .withHeader()
        .sortedBy("personNameHeader", "personAgeHeader")
        .withColumnSeparator(',')
        .withComments();

    MappingIterator<PersonDetailsCSVTemplate> dataIterator =
        csvMapper
            .readerFor(PersonDetailsCSVTemplate.class)
            .with(schema)
            .readValues("personNameHeader,personAgeHeader\r\n"
                +
                "Wiliam,32\r\n");

    while (dataIterator.hasNextValue())
    {
        PersonDetailsCSVTemplate dataCSV = dataIterator.nextValue();

        System.out.println(dataCSV);
    }
}