@Bean
public JdbcBatchItemWriter<OphthalmicLens> writer(DataSource dataSource) throws SQLException {
    return new JdbcBatchItemWriterBuilder<OphthalmicLens>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<OphthalmicLens>() {
                @Override
                public SqlParameterSource createSqlParameterSource(OphthalmicLens item) {
                    return new BeanPropertySqlParameterSource(item) {
                        @Override
                        public int getSqlType(String paramName) {
                            if (paramName.equalsIgnoreCase("desing")) {
                                return Types.VARCHAR;
                            }
                            return super.getSqlType(paramName);
                        }
                    };
                }
            })
            .sql("INSERT INTO OphthalmicLens (`createdBy`,`createdDate`,`lastModifiedBy`,`lastModifiedDate`,`sid`,`version`,`manufacturer`,`manufacturerCode`,`name`,`sku`,`upc`,`cylinder`,`design`,`diameter`,`index`,`material`,`source`,`sphere`,`type`) VALUES (:createdBy,NOW(),:lastModifiedBy,NOW(),UUID(),:version,:manufacturer,:manufacturerCode,:name,:sku,:upc,:cylinder,:design,:diameter,:index,:material,:source,:sphere,:type)")
            .dataSource(dataSource)
            .build();
}