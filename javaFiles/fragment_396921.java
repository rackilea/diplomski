public static <T> ItemWriter<T> createDbItemWriter(DataSource ds, String sql, ItemPreparedStatementSetter<T> psSetter) {
    JdbcBatchItemWriter<T> writer = new JdbcBatchItemWriter<>();

    writer.setDataSource(ds);
    writer.setSql(sql);
    writer.setItemPreparedStatementSetter(psSetter);

    writer.afterPropertiesSet();
    return writer;
}