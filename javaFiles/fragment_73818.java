import org.jooq.util.jaxb.*;

// [...]

Configuration configuration = new Configuration()
    .withJdbc(new Jdbc()
        .withDriver("com.mysql.jdbc.Driver")
        .withUrl("jdbc:mysql://localhost:3306/library")
        .withUser("root")
        .withPassword("root"))
    .withGenerator(new Generator()
        .withName("org.jooq.util.DefaultGenerator")
        .withDatabase(new Database()
            .withName("org.jooq.util.mysql.MySQLDatabase")
            .withIncludes(".*")
            .withExcludes("")
            .withInputSchema("library"))
        .withTarget(new Target()
            .withPackageName("org.jooq.util.maven.example")
            .withDirectory("target/generated-sources/jooq")));

GenerationTool.main(configuration);