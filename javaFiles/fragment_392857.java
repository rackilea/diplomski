public class MyConnectionProvider implements ConnectionProvider, Configurable, Stoppable
{

...

public void configure(Map props) throws HibernateException
    {
        try
        {
            mHikariConfig = HikariConfigurationUtil.loadConfiguration(props);

            if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production)
            {
                mHikariConfig.setDriverClassName("com.mysql.jdbc.GoogleDriver");
                mHikariConfig.setJdbcUrl("jdbc:google:mysql://project-xxx:database/xxx");
                mHikariConfig.setThreadFactory(ThreadManager.backgroundThreadFactory());
            }
            else
            {
                mHikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
                mHikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/xxx");
            }

            mHikariConfig.addDataSourceProperty("databaseName", "xxx");
            mHikariConfig.setUsername("USERNAME");
            mHikariConfig.setPassword("PASSWD");
            mHikariConfig.setRegisterMbeans(false);

            mHikariConfig.setMaximumPoolSize(12);
            mHikariConfig.addDataSourceProperty("cachePrepStmts", "true");
            mHikariConfig.addDataSourceProperty("useServerPrepStmts", "true");
            mHikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
            mHikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

            mHikariDataSource = new HikariDataSource(mHikariConfig);
        }
        catch (Exception e)
        {
            throw new HibernateException(e);
        }
    }

...

}