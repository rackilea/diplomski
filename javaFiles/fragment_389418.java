Properties properties = new Properties();
properties.put("hibernate.show_sql", "true");
properties.put("hibernate.format_sql", "true");
properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
properties.put("hibernate.connection.username", "username");
properties.put("hibernate.connection.password", "password");
properties.put("hibernate.connection.url", "jdbc:mysql://<hostname>:3306/<schema>");

List<String> entitesClass = new ArrayList<>();
entitesClass.add("com.company.entities.Foo");
entitesClass.add("com.company.entities.Bar");
PersistenceUnitInfoImpl punit = new PersistenceUnitInfoImpl("localDB", entitesClass , properties);

PersistenceProvider provider = new HibernatePersistenceProvider();
EntityManagerFactory emf= provider.createContainerEntityManagerFactory(punit, null);

EntityManager em = emf.createEntityManager();
//blablblabl