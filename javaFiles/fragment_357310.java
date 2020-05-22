String configPath = [...]; // Instantiate your configuration path
File file = new File(realPath);
DataSourceProperties dsProp = new DataSourceProperties();
Properties properties = new Properties();
try {
    properties.load(new FileInputStream(file));
} catch (IOException e) {
    throw new TenantNotConfiguredException(tenant); // Custom exception
}

PropertiesConfigurationFactory<DataSourceProperties> pcf = new PropertiesConfigurationFactory<>(dsProp);
pcf.setTargetName(DataSourceProperties.PREFIX);
pcf.setProperties(properties);

try {
    dsProp = pcf.getObject();
} catch (Exception e) {
    e.printStackTrace();
}

return DataSourceBuilder.create()
            .url(dsProp.getUrl())
            .driverClassName(dsProp.getDriverClassName())
            .username(dsProp.getUsername())
            .password(dsProp.getPassword())
            .build();