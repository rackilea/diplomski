@Autowired
static DataSource dataSource;

public static void main(String[] args) {
    PrintLog.print("Server started");
    System.out.println("Server started");
    Flyway flyway = new Flyway();
    flyway.clean();
    flyway.setDataSource(dataSource);
    flyway.setSqlMigrationPrefix("V");
    flyway.setBaselineOnMigrate(true);
    flyway.migrate();
    SpringApplication.run(TimeReportApplication.class, args);
}