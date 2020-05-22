@Bean(name = "firebirdDSLContext")
public DSLContext firebirdDSLContext(@Qualifier("firebirdDataSource") DataSource dataSource) {
    return DSL.using(new DefaultConfiguration()
            .set(dataSource)
            .set(SQLDialect.FIREBIRD)
            .set(new DefaultExecuteListenerProvider(new JooqExceptionTransformer()))
         /* .set(new DefaultRecordMapperProvider()) */ );
}