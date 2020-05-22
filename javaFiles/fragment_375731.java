@Bean
public SpringLiquibase liquibase() {
    SpringLiquibase liquibase = new SpringLiquibaseWriter();
    // ...
    return liquibase;
}

private static class SpringLiquibaseWriter extends SpringLiquibase {

    @Override
    public void afterPropertiesSet() throws LiquibaseException {

        try (Connection connection = getDataSource().getConnection()) {

            Liquibase liquibase = createLiquibase(connection);
            Writer writer; // ... get writer
            liquibase.update(getContexts(), writer);
            // ...

        } catch (LiquibaseException | SQLException e) {
            // handle
        }

        super.afterPropertiesSet();
    }
}