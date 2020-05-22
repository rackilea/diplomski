Configuration config = new Configuration();
config.addAnnotatedClass(AddresseeForDistribution.class);
config.addAnnotatedClass(EmailDistributionAddressee.class);
config.addAnnotatedClass(EmailDistributionTemplate.class);
config.addAnnotatedClass(EmailSent.class);
config.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
new SchemaExport(config).create(true,false); //the true tells it to output to the log/console, the false tells it to not actually touch the db