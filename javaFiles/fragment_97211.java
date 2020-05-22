@BeforeClass
public static void migrateDB(){
    Flyway flyway = Flyway.configure().dataSource(url, user, password).load();
    flyway.clean();
    flyway.migrate();
}