@Configuration
public class CustomConfiguration {
    private final NonExposedProperties nonExposedProperties;
    private DataSource dataSource;

    CustomConfiguration(final NonExposedProperties nonExposedProperties) {
        this.nonExposedProperties= nonExposedProperties;
    }

    public DataSource dataSource() {
        if (Objects.isNull(dataSource)) {
            // Create a standalone instance of DataSourceProperties
            final DataSourceProperties dataSourceProperties = new DataSourceProperties();

            // Use the NonExposedProperties "hikari" Map as properties' source. It will be
            // {
            //    url      -> testUrl
            //    username -> testUsername
            //    password -> testPassword
            //    ... other properties
            // }
            final ConfigurationPropertySource source = new MapConfigurationPropertySource(nonExposedProperties.getHikari());

            // Bind those properties to the DataSourceProperties instance
            final BindResult<DataSourceProperties> binded =
                    new Binder(source).bind(
                            ConfigurationPropertyName.EMPTY,
                            Bindable.ofInstance(dataSourceProperties)
                    );

            // Retrieve the binded instance (it's not a new one, it's the same as before)
            dataSource = binded.get().initializeDataSourceBuilder().build();
        }

        // Return the constructed HikariDataSource
        return dataSource;
    }
}