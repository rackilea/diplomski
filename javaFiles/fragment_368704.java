String postgresqlServiceHost = System.getenv("POSTGRESQL_SERVICE_HOST");
String postgresqlServicePort = System.getenv("POSTGRESQL_SERVICE_PORT");
String postgresqlDatabase = System.getenv("POSTGRESQL_DATABASE");
String postgresqlUser = System.getenv("POSTGRESQL_USER");
String postgresqlPassword = System.getenv("POSTGRESQL_PASSWORD");

Connection connection = DriverManager.getConnection("jdbc:postgresql://" + postgresqlServiceHost + ":" + postgresqlServicePort + "/" + postgresqlDatabase, postgresqlUser, postgresqlPassword);