public class CSVParsing {

      public void parseCSV() throws IOException {

      List<Person> list = Lists.newArrayList();

      String str = "COL1,COL2,COL3\n" +
                   "A,B,23\n" +
                   "S,H,20\n";

      CsvSchema schema = CsvSchema.emptySchema().withHeader();

      ObjectReader mapper = new CsvMapper().reader(Person.class).with(schema);

      MappingIterator<Person> it = mapper.readValues(str);
      while (it.hasNext()) {
          list.add(it.next());
      }

      System.out.println("stored list is:" + (list != null ? list.toString() : null));
  }}