public static class CSV{
    public int x;
    public int y;
}

public final void testJacksonSplit() throws JsonProcessingException, IOException {
    CsvMapper mapper = new CsvMapper();
    CsvSchema schema = CsvSchema.builder().addColumn("x", ColumnType.NUMBER).addColumn("y", ColumnType.NUMBER).setColumnSeparator(' ').build();

    long start = System.currentTimeMillis();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < RUNS; i++) {
        builder.append(line);
        builder.append('\n');
    }       
    String input = builder.toString();
    MappingIterator<CSV> it = mapper.reader(CSV.class).with(schema).readValues(input);
    while (it.hasNext()){
        CSV csv = it.next();
    }
    System.out.println("CsvMapperSplit: " + (System.currentTimeMillis() - start) + "ms");
}