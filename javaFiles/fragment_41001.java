@Provides
@Singleton
@Priority(Priority.Level.HIGH)
public static ReportingDal createHighPriorityReportingDal(DataSource dataSource,
                                                          DatabaseType databaseType,
                                                          ReportingQueryGenerator queryGenerator)
{
    return new ReportingDalImpl(dataSource, databaseType, Queue.DEFAULT, queryGenerator);
}

@Provides
@Singleton
@Priority(Priority.Level.LOW)
public static ReportingDal createLowPriorityReportingDal(DataSource dataSource,
                                                         DatabaseType databaseType,
                                                         ReportingQueryGenerator queryGenerator)
{
    return new ReportingDalImpl(dataSource, databaseType, Queue.MAINTENANCE, queryGenerator);
}