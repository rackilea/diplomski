public class MyWriter extends ItemWriter<MyDto> {

    private Map<String, JdbcBatchItemWriter<MyDto>> writersMaps = new HashMap<>();

    private JdbcBatchItemWriter<MyDto> getDbWriter(String tableName) throws Exception {
        return writersMaps.putIfAbsent(tableName, createJdbcWriter(tableName));

    }

    private JdbcBatchItemWriter<MyDto> createJdbcWriter(String tableName) {
          JdbcBatchItemWriter<T> writer = new JdbcBatchItemWriter<>();

          // do your configuration

          writer.afterPropertiesSet();
          return writer;
    }

    public void write(List<MyDto> items) throws Exception {
        Map<String, List<MyDto>> groupedItems = 
                --> build a list for every targetTableName, put in a Map


        for (Map.Entry<String, List<MyDto>> entry : groupedItems) {
            getDbWriter(entry.getKey()).write(entry.getValue);
        }
    }
}