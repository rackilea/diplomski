// Initializing Flyway
Flyway flyway = new Flyway();
flyway.setDataSource(dataSource);

flyway.setValidateOnMigrate(true);

// Register call back. 
FruitShopFlywayCallback callback = new FruitShopFlywayCallback();
flyway.setCallbacks(callback);